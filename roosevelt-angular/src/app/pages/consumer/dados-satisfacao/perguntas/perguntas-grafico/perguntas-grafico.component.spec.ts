import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PerguntasGraficoComponent } from './perguntas-grafico.component';

describe('PerguntasGraficoComponent', () => {
  let component: PerguntasGraficoComponent;
  let fixture: ComponentFixture<PerguntasGraficoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PerguntasGraficoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PerguntasGraficoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
