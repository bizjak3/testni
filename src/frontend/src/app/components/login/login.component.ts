import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login/login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  submitted = false;
  emptyPassword = true;
  username = '';
  showSuccess = false;
  isOnline = false; // to bila funkcija
  public prijava = {
    username: '',
    geslo: '',
  };
  public napakaNaObrazcu = '';

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {}

  public login() {
    this.loginService
      .login(this.prijava.username, this.prijava.geslo)
      .then((data) => {
        // todo popravi kam linkat
        if (data == true) {
          alert("Prijava uspešna: " + this.loginService.userLoggedIn.username);
          this.router.navigate(['/']);
        } else {
          this.napakaNaObrazcu = 'Napaka pri prijavi';
        }
      })
      .catch(() => (this.napakaNaObrazcu = 'Napaka pri prijavi'));
  }
}
