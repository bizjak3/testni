import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-navbar-login-signup',
  templateUrl: './navbar-login-signup.component.html',
  styleUrls: ['./navbar-login-signup.component.scss'],
})
export class NavbarLoginSignupComponent implements OnInit {
  public showLoginRegister: boolean = true;

  constructor(private router: Router) {
    this.router.events.subscribe((e) => {
      if (e instanceof NavigationEnd)
        this.showLoginRegister =
          e.url.toLowerCase().includes('/signup') ||
          e.url.toLowerCase() === '/login' ||
          e.url.toLowerCase() === '/';
    });
  }

  ngOnInit(): void {}
}
