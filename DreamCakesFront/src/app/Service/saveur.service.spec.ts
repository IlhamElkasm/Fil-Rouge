import { TestBed } from '@angular/core/testing';

import { SaveurService } from './saveur.service';

describe('SaveurService', () => {
  let service: SaveurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SaveurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
