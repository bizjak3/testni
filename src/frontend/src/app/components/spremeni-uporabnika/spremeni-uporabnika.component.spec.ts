import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpremeniUporabnikaComponent } from './spremeni-uporabnika.component';

describe('SpremeniUporabnikaComponent', () => {
  let component: SpremeniUporabnikaComponent;
  let fixture: ComponentFixture<SpremeniUporabnikaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpremeniUporabnikaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpremeniUporabnikaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
