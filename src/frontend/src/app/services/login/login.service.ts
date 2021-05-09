import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { env } from 'process';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl: string = env.BASE_URL;

  constructor(private http: HttpClient) { }
}
