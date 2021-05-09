import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

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
