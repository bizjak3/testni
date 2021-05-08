import { TestBed } from '@angular/core/testing';

import { ToBeDeletedService } from './to-be-deleted.service';

describe('ToBeDeletedService', () => {
  let service: ToBeDeletedService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ToBeDeletedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
