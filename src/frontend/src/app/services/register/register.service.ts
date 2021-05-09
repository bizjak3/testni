import { Injectable } from '@angular/core';
import { env } from 'process';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private baseUrl: string = env.BASE_URL;

  constructor(private http: HttpClient) { }

  public registerOwner(uporabnik: any) {
    return this.http.post(this.baseUrl + '/register/dog-owner', uporabnik);
  }

  public registerWorker(uporabnik: any) {
    return this.http.post(this.baseUrl + '/register/service-worker', uporabnik);
  }
}
