import { Component, OnInit } from '@angular/core';
import {User} from '../../models/user';
import {UserService} from '../../services/user/user.service';
import {ActivatedRoute} from '@angular/router';
import {HttpErrorResponse} from '@angular/common/http';
import {ErrorWrapper} from '../../models/error/ErrorWrapper';

@Component({
  selector: 'app-public-profile',
  templateUrl: './public-profile.component.html',
  styleUrls: ['./public-profile.component.scss']
})
export class PublicProfileComponent implements OnInit {

  public user: User;
  public errors: string[] | null = null;
  public loading: boolean = false;

  constructor(private userApi: UserService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.loading = true;
    this.activatedRoute.params.subscribe(params => {
      if(params.username) {
        this.userApi.getPublicUserData(params.username).subscribe((data) => {
          this.user = data;
          console.log(this.user);
          this.loading = false;
        }, (e: HttpErrorResponse) => {
          this.errors = (e.error as ErrorWrapper).errors;
        });
      }
    });
  }

}
