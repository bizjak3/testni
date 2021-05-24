import { Component, Input, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { User } from 'src/app/models/user';
import { MessageApiService } from 'src/app/services/message-api.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-new-message-modal',
  templateUrl: './new-message-modal.component.html',
  styleUrls: ['./new-message-modal.component.scss'],
})
export class NewMessageModalComponent implements OnInit {
  @Input() uporabnik: User;
  public message: string = '';

  constructor(
    public activeModal: NgbActiveModal,
    private messageService: MessageApiService
  ) {}

  ngOnInit(): void {
    console.log('To je uporabnik v modalu ' + this.uporabnik.name);
  }

  public async sendMessage(): Promise<void> {
    await (
      await this.messageService.sendMessage(
        { text: this.message },
        this.uporabnik.username
      )
    ).subscribe((data) => {
      console.log(data);
      alert('Sporočilo je bilo poslano');
      this.activeModal.close();
    });
  }
}
