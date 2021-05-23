import {Component, Input, OnInit} from '@angular/core';
import { User } from '../../models/user';

@Component({
  selector: 'app-uporabnik',
  templateUrl: './uporabnik.component.html',
  styleUrls: ['./uporabnik.component.scss']
})
export class UporabnikComponent implements OnInit {
  @Input() uporabnik: User;

  constructor() { }

  ngOnInit(): void {
  }

}
