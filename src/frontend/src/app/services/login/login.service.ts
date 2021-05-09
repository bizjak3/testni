import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { env } from 'process';

@Injectable({
  providedIn: 'root',
})
export class LoginService implements CanActivate {
  private baseUrl: string = env.BASE_URL;
  private _bearer: string;

  private static authorizationHeader: string = 'Authorization';
  private static refreshTimeHeader: string = 'Refresh-Token-After';

  constructor(private http: HttpClient, private router: Router) {}

  public async login(username: string, password: string): Promise<void> {
    const response = await this.http.post<any>(
      this.baseUrl + 'login',
      { username, password },
      {
        observe: 'response',
      }
    ).toPromise();

    this._bearer = response.headers.get(LoginService.authorizationHeader);
  }

  public canActivate(): boolean {
    if (this._bearer == null) {
      this.router.navigate(['']);
      return false;
    } /* else if (this.isJwtExpired()) {
      Swal.fire({
        title: 'Seja je potekla',
        text: 'Potrebna je ponovna prijava',
        icon: 'warning',
        confirmButtonColor: Styles.info,
      });
      this.router.navigate(['']);
      return false;
    } */ else {
      return true;
    }
  }

  public get bearer() {
    return this._bearer;
  }
}
