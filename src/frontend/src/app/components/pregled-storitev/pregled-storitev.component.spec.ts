import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PregledStoritevComponent } from './pregled-storitev.component';

describe('PregledStoritevComponent', () => {
  let component: PregledStoritevComponent;
  let fixture: ComponentFixture<PregledStoritevComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PregledStoritevComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PregledStoritevComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
