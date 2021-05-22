import { Injectable } from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {User} from '../../models/user';
import { LoginService } from '../login/login.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl: string = environment.BASE_URL + 'users/';

  constructor(private http: HttpClient, private loginService: LoginService) { }

  public async updateUser(uporabnik: User) {
    console.log("here");
    const headers = await this.loginService.getAuthorizationHeader();
    return this.http.put<User>(this.baseUrl + 'put', uporabnik, {headers});
  }
}
