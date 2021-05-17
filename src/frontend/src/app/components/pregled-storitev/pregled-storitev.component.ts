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
  public services: Service[] = [
    {
      id: 15,
      name: 'Sprehajanje',
      description:
        'khdflahsf iauhsdij hfiduhgai uriguh idfuhsadifu hasiufh isufh',
      restrictions:
        'khdflahsf iauhsdij hfiduhgai uriguh idfuhsadifu hasiufh isufh',
      dateFrom: new Date(),
      dateTo: new Date(),
      author: { name: 'Kleopater', surname: 'Igislav' },
    },
    {
      id: 15,
      name: 'Sprehajanje',
      description:
        'khdflahsf iauhsdij hfiduhgai uriguh idfuhsadifu hasiufh isufh',
      restrictions:
        'khdflahsf iauhsdij hfiduhgai uriguh idfuhsadifu hasiufh isufh',
      dateFrom: new Date(),
      dateTo: new Date(),
      author: { name: 'Kleopater', surname: 'Igislav' },
    },
  ];
  public loading: boolean = false;
  public error: string | null = null;

  constructor(private serviceServices: ServiceService) {}

  ngOnInit(): void {
    // this.getData();
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
