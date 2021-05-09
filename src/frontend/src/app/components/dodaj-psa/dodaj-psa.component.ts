import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dodaj-psa',
  templateUrl: './dodaj-psa.component.html',
  styleUrls: ['./dodaj-psa.component.scss']
})
export class DodajPsaComponent implements OnInit {

  public pes = {
    ime: "",
    pasma: "",
    komentarji: ""
  }
  constructor() { }

  ngOnInit(): void {
  }

  public dodajPsa() {
    console.log(this.pes);
  }

}
