import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZacetnaStranComponent } from './zacetna-stran.component';

describe('ZacetnaStranComponent', () => {
  let component: ZacetnaStranComponent;
  let fixture: ComponentFixture<ZacetnaStranComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZacetnaStranComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZacetnaStranComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
