import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-zacetna-stran',
  templateUrl: './zacetna-stran.component.html',
  styleUrls: ['./zacetna-stran.component.scss'],
})
export class ZacetnaStranComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  public navigateToSignUp(tip: string): void {
    this.router.navigate(['/signup', tip]);
  }
}
