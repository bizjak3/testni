import { Component, OnInit } from '@angular/core';
import {UserService} from '../../services/user/user.service';
import { Router} from '@angular/router';
import {LoginService} from '../../services/login/login.service';
import {User} from '../../models/user';
import {addWarning} from '@angular-devkit/build-angular/src/utils/webpack-diagnostics';
import {HttpErrorResponse} from '@angular/common/http';
import {ErrorWrapper} from '../../models/error/ErrorWrapper';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.scss']
})
export class EditProfileComponent implements OnInit {
  public user: User = {
    name: '',
    surname: '',
    username: '',
    email: ''
  };

  public napakaNaObrazcu = '';

  constructor(private userService: UserService, private router: Router, private loginService: LoginService) {
    this.user = this.loginService.userLoggedIn;
  }

  ngOnInit(): void {
  }

  public async posodobiUporabnika() {
    this.loginService.userLoggedIn.name = (this.user.name === '' ? this.loginService.userLoggedIn.name : this.user.name);
    // this.loginService.userLoggedIn.name = 'nivecizvajalec';
    this.loginService.userLoggedIn.surname = (this.user.surname === '' ? this.loginService.userLoggedIn.surname : this.user.surname);
    this.loginService.userLoggedIn.username = (this.user.username === '' ? this.loginService.userLoggedIn.username : this.user.username);
    this.loginService.userLoggedIn.email = (this.user.email === '' ? this.loginService.userLoggedIn.email : this.user.email);
    // this.userService
    //   .updateUser(this.loginService.userLoggedIn)
    //   .then((data) => {
    //     if (data === true) {
    //       alert('Uporabnik uspešno posodobljen');
    //       this.router.navigate(['/profil']);
    //     } else {
    //       this.napakaNaObrazcu = 'Napaka pri posodabljanju uporabnika';
    //     }
    //   })
    //   .catch(() => (this.napakaNaObrazcu = 'Napaka pri posodabljanju uporabnika'));
    const observable = await this.userService.updateUser(this.loginService.userLoggedIn);
    observable.subscribe((data) => {
      alert('Uporabnik posodobljen');
      this.router.navigate(['/profil']);
    }, (err: HttpErrorResponse) => {
      const errorWrapper: ErrorWrapper = err.error;
      console.log(errorWrapper);
      // errors = errorWrapper.errors
    });
  }

}
