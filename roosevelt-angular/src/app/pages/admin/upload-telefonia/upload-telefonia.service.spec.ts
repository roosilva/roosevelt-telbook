import { TestBed, inject } from '@angular/core/testing';

import { UploadTelefoniaService } from './upload-telefonia.service';

describe('UploadTelefoniaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UploadTelefoniaService]
    });
  });

  it('should be created', inject([UploadTelefoniaService], (service: UploadTelefoniaService) => {
    expect(service).toBeTruthy();
  }));
});
