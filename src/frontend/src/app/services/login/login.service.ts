import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { environment } from 'src/environments/environment';
import jwt_decode from "jwt-decode";

@Injectable({
  providedIn: 'root',
})
export class LoginService implements CanActivate {
  private baseUrl: string = environment.BASE_URL;
  private _bearer: string;
  private _userLoggedIn: User;

  private static authorizationHeader: string = 'Authorization';
  private static refreshTimeHeader: string = 'Refresh-Token-After';

  constructor(private http: HttpClient, private router: Router) {}

  public async login(username: string, password: string): Promise<boolean> {
    const response = await this.http
      .post<any>(
        this.baseUrl + 'login',
        { username, password },
        {
          observe: 'response',
        }
      )
      .toPromise();

    this._bearer = response.headers.get(LoginService.authorizationHeader);

    const headers = {"Authorization": this._bearer};
    this._userLoggedIn = await this.http.get<User>(this.baseUrl + "users/me", {headers}).toPromise();
    this.userLoggedIn.password = password;

    return true;
  }

  public canActivate(): boolean {

    let decoded;
    try {
      decoded = jwt_decode(this._bearer);
    }catch (er) {
      this.router.navigate(['']);
      return false;
    }

    console.log(decoded);

    if (this._bearer == null) {
      this.router.navigate(['']);
      return false;
    } else if (decoded.exp <= (new Date().getTime() / 1000)) {
      alert("Seja je zaključena");
      /* Swal.fire({
        title: 'Seja je potekla',
        text: 'Potrebna je ponovna prijava',
        icon: 'warning',
        confirmButtonColor: Styles.info,
      }); */
      this.router.navigate(['']);
      return false;
    } else {
      return true;
    }
  }

  public async bearer() {
    let decoded: any = jwt_decode(this._bearer);
    console.log(decoded);

    if(decoded.exp <= new Date()) {
      await this.login(this.userLoggedIn.username, this.userLoggedIn.password);
    }

    return this._bearer;
  }

  public get userLoggedIn() {
    return this._userLoggedIn;
  }

  public async getAuthorizationHeader(): Promise<HttpHeaders>{
    const bearer = await this.bearer();
    return new HttpHeaders({"Authorization": bearer});
  }
}
