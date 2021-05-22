import { TestBed } from '@angular/core/testing';

import { DogoService } from './dogo.service';

describe('DogoService', () => {
  let service: DogoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DogoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
