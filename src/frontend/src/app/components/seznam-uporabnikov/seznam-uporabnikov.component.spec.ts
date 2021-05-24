import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeznamUporabnikovComponent } from './seznam-uporabnikov.component';

describe('SeznamUporabnikovComponent', () => {
  let component: SeznamUporabnikovComponent;
  let fixture: ComponentFixture<SeznamUporabnikovComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeznamUporabnikovComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeznamUporabnikovComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
