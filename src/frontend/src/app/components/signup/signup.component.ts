import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  public uporabnik = {
    lastnik: false,
    izvajalec: false
  };
  submitted = false;
  emptyPassword = true;
  username = '';
  showSuccess = false;
  isOnline = false; // to bila funkcija
  public napakaNaObrazcu = '';

  public kajJe() {
    console.log(this.uporabnik.lastnik ? 'je lastnik' : 'je izvajalec');
  }

  constructor() { }

  ngOnInit(): void {
  }

  radioChangeHandler(event: any) {
    console.log(event.target.value);
  }

}
