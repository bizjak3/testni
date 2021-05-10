import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Service } from 'src/app/models/service';
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
}
