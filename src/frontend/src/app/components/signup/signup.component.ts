import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  submitted = false;
  emptyPassword = true;
  username = '';
  showSuccess = false;
  isOnline = false; // to bila funkcija
  public napakaNaObrazcu = '';

  constructor() { }

  ngOnInit(): void {
  }

}
