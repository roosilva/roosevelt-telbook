import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DadosSatisfacaoComponent } from './dados-satisfacao.component';

describe('DadosSatisfacaoComponent', () => {
  let component: DadosSatisfacaoComponent;
  let fixture: ComponentFixture<DadosSatisfacaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DadosSatisfacaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DadosSatisfacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
