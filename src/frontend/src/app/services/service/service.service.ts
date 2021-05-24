import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Dogo } from 'src/app/models/dogo';
import { Service } from 'src/app/models/service';
import { ServiceDiary } from 'src/app/models/service_diary';
import { environment } from 'src/environments/environment';
import { LoginService } from '../login/login.service';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private baseUrl: string = environment.BASE_URL + "services/";

  constructor(private http: HttpClient, private loginService: LoginService) { }

  public async postNewService(service: Service): Promise<Observable<Service>> {
    const headers = await this.loginService.getAuthorizationHeader();

    return this.http.post<Service>(this.baseUrl + "add", service, {headers});
  }

  public async getAllActiveServices(): Promise<Observable<Service[]>> {
    const headers = await this.loginService.getAuthorizationHeader();

    return this.http.get<Service[]>(this.baseUrl + "all", {headers});
  }

  public async getAllActiveUserServices(): Promise<Observable<Service[]>> {
    const headers = await this.loginService.getAuthorizationHeader();

    return this.http.get<Service[]>(this.baseUrl + "user-service-all", {headers});
  }

  public async postServiceDiary(service: Service, dogo: Dogo): Promise<Observable<any>>{
    const headers = await this.loginService.getAuthorizationHeader();

    let sd = {
      dogo: null,
      service: null,
    }

    return this.http.post(this.baseUrl + "post-service-diary" + "?dogoId=" + dogo.id + "&serviceId=" + service.id, sd, {headers});
  }

  public async getOrderedServices(): Promise<Observable<Service[]>> {
    const headers = await this.loginService.getAuthorizationHeader();

    return this.http.get<Service[]>(this.baseUrl + "get-ordered-services", {headers});
  }
}
