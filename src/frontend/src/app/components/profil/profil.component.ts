import { Component, OnInit } from '@angular/core';
import {LoginService} from '../../services/login/login.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss']
})
export class ProfilComponent implements OnInit {
  public user = {
    name: '',
    surname: '',
    username: '',
    isDogOwner: false,
    email: ''
  };

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    this.user.name = this.loginService.userLoggedIn.name;
    this.user.username = this.loginService.userLoggedIn.username;
    this.user.surname = this.loginService.userLoggedIn.surname;
    this.user.email = this.loginService.userLoggedIn.email;
    this.user.isDogOwner = this.loginService.userLoggedIn.isDogOwner;
    console.log(this.loginService.userLoggedIn.name);
  }

}
