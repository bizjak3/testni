import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Dogo } from 'src/app/models/dogo';
import { environment } from 'src/environments/environment';
import { LoginService } from '../login/login.service';

@Injectable({
  providedIn: 'root'
})
export class DogoService {

  private baseUrl: string = environment.BASE_URL;

  constructor(private http: HttpClient, private loginService: LoginService) { }

  public async addDogoPost(dogo: Dogo){
    const headers = await this.loginService.getAuthorizationHeader();
    return this.http.post(this.baseUrl + 'dogos/post', dogo, {headers});
  }
}
