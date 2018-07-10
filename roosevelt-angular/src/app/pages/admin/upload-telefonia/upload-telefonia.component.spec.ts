import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadTelefoniaComponent } from './upload-telefonia.component';

describe('UploadTelefoniaComponent', () => {
  let component: UploadTelefoniaComponent;
  let fixture: ComponentFixture<UploadTelefoniaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploadTelefoniaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadTelefoniaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
