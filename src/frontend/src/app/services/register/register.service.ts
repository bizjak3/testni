import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private baseUrl: string = environment.BASE_URL;

  constructor(private http: HttpClient) { }

  public registerOwner(uporabnik: any) {
    console.log("hello");
    return this.http.post(this.baseUrl + 'register/dog-owner', uporabnik);
  }

  public registerWorker(uporabnik: any) {
    return this.http.post(this.baseUrl + 'register/service-worker', uporabnik);
  }
}
