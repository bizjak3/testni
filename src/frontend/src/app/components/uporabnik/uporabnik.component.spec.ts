import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UporabnikComponent } from './uporabnik.component';

describe('UporabnikComponent', () => {
  let component: UporabnikComponent;
  let fixture: ComponentFixture<UporabnikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UporabnikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UporabnikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
