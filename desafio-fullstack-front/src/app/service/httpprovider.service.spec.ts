import { TestBed } from '@angular/core/testing';

import { HttpproviderService } from './httpprovider.service';

describe('HttpproviderService', () => {
  let service: HttpproviderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpproviderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
