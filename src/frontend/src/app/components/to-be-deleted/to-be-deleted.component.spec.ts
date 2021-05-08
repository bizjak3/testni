import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToBeDeletedComponent } from './to-be-deleted.component';

describe('ToBeDeletedComponent', () => {
  let component: ToBeDeletedComponent;
  let fixture: ComponentFixture<ToBeDeletedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ToBeDeletedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ToBeDeletedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
