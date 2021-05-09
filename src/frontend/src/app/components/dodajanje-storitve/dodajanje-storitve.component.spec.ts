import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajanjeStoritveComponent } from './dodajanje-storitve.component';

describe('DodajanjeStoritveComponent', () => {
  let component: DodajanjeStoritveComponent;
  let fixture: ComponentFixture<DodajanjeStoritveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DodajanjeStoritveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DodajanjeStoritveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
