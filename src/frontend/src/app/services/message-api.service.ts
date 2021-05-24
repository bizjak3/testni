import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Message } from '../models/message';
import { MessageRoot } from '../models/messages/message_root';
import { LoginService } from './login/login.service';

@Injectable({
  providedIn: 'root',
})
export class MessageApiService {
  private baseUrl = environment.BASE_URL + 'messages/';

  constructor(private http: HttpClient, private loginService: LoginService) {}

  public async sendMessage(
    message: Message,
    sendTo: string
  ): Promise<Observable<Message>> {
    const headers = await this.loginService.getAuthorizationHeader();
    return this.http.post<Message>(this.baseUrl + 'post-message?receiver=' + sendTo, message, { headers });
  }

  public async getMyMessages(): Promise<Observable<MessageRoot[]>> {
    const headers = await this.loginService.getAuthorizationHeader();
    return this.http.get<MessageRoot[]>(this.baseUrl, { headers });
  }
}
