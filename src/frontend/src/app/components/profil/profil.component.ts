import { Component, OnInit } from '@angular/core';
import {LoginService} from '../../services/login/login.service';
import {Subscription} from 'rxjs';
import {UserService} from '../../services/user/user.service';
import { User } from '../../models/user';

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

  public user1: User;
  public loading: boolean = false;
  public error: string | null = null;

  constructor(private loginService: LoginService, private userService: UserService) { }

  ngOnInit(): void {
    this.user.name = this.loginService.userLoggedIn.name;
    this.user.username = this.loginService.userLoggedIn.username;
    this.user.surname = this.loginService.userLoggedIn.surname;
    this.user.email = this.loginService.userLoggedIn.email;
    this.user.isDogOwner = this.loginService.userLoggedIn.isDogOwner;
    console.log(this.loginService.userLoggedIn.name);
    this.getData();
    console.log('To je user one: ' + this.user1);
  }

  async getData(): Promise<void> {
    this.loading = true;
    this.error = null;
    const observable = await this.userService.getMe();
    console.log('Sem v getData v profilu');
    observable.subscribe(
      (data) => {
        this.user1 = data;
        this.loading = false;
      },
      () => {
        this.loading = false;
        this.error = 'Napaka pri pridobivanju podatkov';
      }
    );
  }

}
