import { TestBed } from '@angular/core/testing';

import { GarnitureService } from './garniture.service';

describe('GarnitureService', () => {
  let service: GarnitureService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GarnitureService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
