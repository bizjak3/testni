import { Component, OnInit } from '@angular/core';
import { interval } from 'rxjs';
import { MessageRoot } from 'src/app/models/messages/message_root';
import { MessageApiService } from 'src/app/services/message-api.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.scss'],
})
export class MessagesComponent implements OnInit {
  public messages: MessageRoot[];
  public selected: MessageRoot;
  private selectedIndex: number = 0;

  public message: string = '';

  public loading = false;
  public error: string | null = null;

  private updater = interval(10000);

  constructor(private messageServices: MessageApiService) {
    this.getMessages();
    this.updater.subscribe(() => this.getMessagesSilently());
  }

  private async getMessages(): Promise<void> {
    this.loading = true;

    (await this.messageServices.getMyMessages()).subscribe(
      (data) => {
        this.messages = data;
        this.loading = false;
        console.log(data);
        this.selected = this.messages[this.selectedIndex];
      },
      () => (this.error = 'Napaka')
    );
  }

  private async getMessagesSilently(): Promise<void> {
    (await this.messageServices.getMyMessages()).subscribe((data) => {
      this.messages = data;
      this.selected = this.messages[this.selectedIndex];
    });
  }

  public async sendMessage(): Promise<void> {
    (
      await this.messageServices.sendMessage(
        { text: this.message },
        this.selected.username
      )
    ).subscribe(() => {
      this.message = "";
      this.getMessages();
    });
  }

  public changeView(index: number): void {
    this.selectedIndex = index;
    this.selected = this.messages[index];
  }

  ngOnInit(): void {}
}
