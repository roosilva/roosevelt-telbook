import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ConsumerComponent } from './consumer.component';

import { DadosSatisfacaoComponent } from './dados-satisfacao/dados-satisfacao.component';
import { PerguntasComponent } from './dados-satisfacao/perguntas/perguntas.component';
import { PerguntasGraficoComponent } from './dados-satisfacao/perguntas/perguntas-grafico/perguntas-grafico.component';
import { EstadosComponent } from './dados-satisfacao/estados/estados.component';
import { EstadosGraficoComponent } from './dados-satisfacao/estados/estados-grafico/estados-grafico.component';

const routes: Routes = [{
  path: '',
  component: ConsumerComponent,
  children: [{
    path: 'dados-satisfacao',
    component: DadosSatisfacaoComponent,
  }, {
    path: 'dados-satisfacao/perguntas',
    component: PerguntasComponent,
  },
  {
    path: 'dados-satisfacao/perguntas/perguntas-grafico',
    component: PerguntasGraficoComponent,
  },
  {
    path: 'dados-satisfacao/estados',
    component: EstadosComponent,
  },
  {
    path: 'dados-satisfacao/estados/estados-grafico',
    component: EstadosGraficoComponent,
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ConsumerRoutingModule { }

export const routedComponents = [
  ConsumerComponent,
];
