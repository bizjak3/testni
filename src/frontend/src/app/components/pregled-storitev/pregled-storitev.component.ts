import { HttpErrorResponse } from '@angular/common/http';
import { AfterViewInit, Component, OnInit } from '@angular/core';
import { ErrorWrapper } from 'src/app/models/error/ErrorWrapper';
import { Service } from 'src/app/models/service';
import { ServiceService } from 'src/app/services/service/service.service';
import { LoginService } from 'src/app/services/login/login.service';
import * as L from "leaflet";
import * as geo from "esri-leaflet-geocoder"
import { User } from 'src/app/models/user';
import { DogoService } from 'src/app/services/dogo/dogo.service';
import { Dogo } from 'src/app/models/dogo';


const iconRetinaUrl = '../../assets/pictures/marker-icon-2x.png';
const iconUrl = '../../assets/pictures/marker-icon.png';
const shadowUrl = '../../assets/pictures/marker-shadow.png';
const iconDefault = L.icon({
  iconRetinaUrl,
  iconUrl,
  shadowUrl,
  iconSize: [25, 41],
  iconAnchor: [12, 41],
  popupAnchor: [1, -34],
  tooltipAnchor: [16, -28],
  shadowSize: [41, 41]
});
L.Marker.prototype.options.icon = iconDefault;

var geocodeService = geo.geocodeService();

@Component({
  selector: 'app-pregled-storitev',
  templateUrl: './pregled-storitev.component.html',
  styleUrls: ['./pregled-storitev.component.scss'],
})

export class PregledStoritevComponent implements OnInit, AfterViewInit {
  public services;
  public loading: boolean = false;
  public error: string | null = null;

  public maps;

  public user: User;

  public service;
  public dogos;
  public dogo;

  private observable;

  public searchInput: string = "";

  constructor(private serviceServices: ServiceService, private loginService: LoginService, private dogoService: DogoService) {}

  ngOnInit(): void {
    this.user = this.loginService.userLoggedIn;

    this.getData();
  }

  ngAfterViewInit(): void{

  }

  async getData(): Promise<void> {
    this.loading = true;
    this.error = null;
    const observable = await this.serviceServices.getAllActiveServices();
    observable.subscribe(
      (data) => {
        this.services = data;
        this.loading = false;
        setTimeout(() => this.initMap(), 1000)
      },
      () => {
        this.loading = false;
        this.error = 'Napaka pri pridobivanju podatkov';
      }
    );

    if(this.user.isDogOwner){
      const obs = await this.dogoService.getUserDogos();
      obs.subscribe((data) => {
        this.dogos = data;
      })
    }
    
  }

  private initMap(){
    this.maps = [];
    this.services.forEach((value) => {
      console.log("map" + value.id);
      let map = L.map('map' + value.id, {
        center: [value.locations[0].geoLat, value.locations[0].geoLon],
        zoom: 8
      });
  
      L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '&copy <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
      }).addTo(map);

      L.marker([value.locations[0].geoLat, value.locations[0].geoLon]).addTo(map);

      this.maps.push(map);
    }); 
  }

  public async narociStoritev(service: Service){
    console.log(this.dogo, service);
    this.service = service;
    const observable = await this.serviceServices.postServiceDiary(service, this.dogo);
      observable.subscribe((data) => {
        alert("Naročen");
      }, (err: HttpErrorResponse) => {
        const errorWrapper: ErrorWrapper = err.error;
        console.log(errorWrapper);
      })
  }

  public odjaviGaK(): void {
    this.loginService.logOut();
  }

}
