import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajPsaComponent } from './dodaj-psa.component';

describe('DodajPsaComponent', () => {
  let component: DodajPsaComponent;
  let fixture: ComponentFixture<DodajPsaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DodajPsaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DodajPsaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
