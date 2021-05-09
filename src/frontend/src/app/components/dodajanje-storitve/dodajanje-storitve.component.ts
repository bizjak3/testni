import { Component, OnInit } from '@angular/core';
import * as L from "leaflet";
import * as geo from "esri-leaflet-geocoder"



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
  selector: 'app-dodajanje-storitve',
  templateUrl: './dodajanje-storitve.component.html',
  styleUrls: ['./dodajanje-storitve.component.scss']
})
export class DodajanjeStoritveComponent implements OnInit {
  private map;
  public storitev = {
    ime: "",
    lat: "",
    lng: "",
    datum_from: "",
    datum_to: "",
    komentarji: "",
    omejitve: ""

  }
  constructor() { }

  ngOnInit(): void {
    this.initMap();
  }

  private initMap(): void {
    this.map = L.map('map', {
      center: [46.050596, 14.506015],
      zoom: 8
    });

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 19,
      attribution: '&copy <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);

    var marker = null;

    this.map.on('click', e => {
      if (marker != null) {
        this.map.removeLayer(marker);
      }
      marker = new L.marker(e.latlng).addTo(this.map);
      console.log(e.latlng.lat, e.latlng.lng);
      this.storitev.lat = e.latlng.lat;
      this.storitev.lng = e.latlng.lng;
      geocodeService.reverse().latlng(e.latlng).run((error, result) => {
        
        
      })
    })
  }

  public dodajStoritev () {
    console.log(this.storitev);
  }

}
