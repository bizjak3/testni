import { Injectable } from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {User} from '../../models/user';
import { LoginService } from '../login/login.service';
import {Observable} from 'rxjs';
import {Service} from '../../models/service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl: string = environment.BASE_URL + 'users';

  constructor(private http: HttpClient, private loginService: LoginService) { }

  public async updateMe(uporabnik: User) {
    const headers = await this.loginService.getAuthorizationHeader();
    return this.http.put<User>(this.baseUrl + '/put-me', uporabnik, {headers});
  }

  public async updateUser(uporabnik: User): Promise<Observable<User>> {
    const headers = await this.loginService.getAuthorizationHeader();

    return this.http.put<User>(this.baseUrl + '/put', uporabnik, {headers});
  }

  public async getAllUsers(): Promise<Observable<User[]>> {
    const headers = await this.loginService.getAuthorizationHeader();
    console.log('Sem v getAllUsers');

    return this.http.get<User[]>(this.baseUrl + '/get-all', {headers});
  }

  public async getMe(): Promise<Observable<User>> {
    const headers = await this.loginService.getAuthorizationHeader();
    console.log('Sem v getMe');

    return this.http.get<User>(this.baseUrl + '/me', {headers});
  }

  public getPublicUserData(username: string): Observable<User> {
    return this.http.get<User>(this.baseUrl + '?username=' + username);
  }
}
