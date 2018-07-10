import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstadosGraficoComponent } from './estados-grafico.component';

describe('EstadosGraficoComponent', () => {
  let component: EstadosGraficoComponent;
  let fixture: ComponentFixture<EstadosGraficoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EstadosGraficoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstadosGraficoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
