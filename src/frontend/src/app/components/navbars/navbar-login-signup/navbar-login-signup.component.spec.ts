import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarLoginSignupComponent } from './navbar-login-signup.component';

describe('NavbarLoginSignupComponent', () => {
  let component: NavbarLoginSignupComponent;
  let fixture: ComponentFixture<NavbarLoginSignupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarLoginSignupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarLoginSignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
