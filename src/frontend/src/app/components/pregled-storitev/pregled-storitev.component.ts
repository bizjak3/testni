import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ErrorWrapper } from 'src/app/models/error/ErrorWrapper';
import { Service } from 'src/app/models/service';
import { ServiceService } from 'src/app/services/service/service.service';

@Component({
  selector: 'app-pregled-storitev',
  templateUrl: './pregled-storitev.component.html',
  styleUrls: ['./pregled-storitev.component.scss'],
})
export class PregledStoritevComponent implements OnInit {
  public services: Service[];
  public loading: boolean = false;
  public error: string | null = null;

  constructor(private serviceServices: ServiceService) {}

  ngOnInit(): void {
    this.getData();
  }

  async getData(): Promise<void> {
    this.loading = true;
    this.error = null;
    const observable = await this.serviceServices.getAllActiveServices();
    observable.subscribe(
      (data) => {
        this.services = data;
        this.loading = false;
      },
      () => {
        this.loading = false;
        this.error = 'Napaka pri pridobivanju podatkov';
      }
    );
  }
}
