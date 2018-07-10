import { NgModule } from '@angular/core';
import { NgxEchartsModule } from 'ngx-echarts';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { ChartModule } from 'angular2-chartjs';

import { ThemeModule } from '../../@theme/theme.module';

import { ConsumerRoutingModule, routedComponents } from './consumer-routing.module';

import { DadosSatisfacaoComponent } from './dados-satisfacao/dados-satisfacao.component';
import { PerguntasComponent } from './dados-satisfacao/perguntas/perguntas.component';
import { PerguntaService } from './dados-satisfacao/perguntas/pergunta.service';
import { PerguntasGraficoComponent } from './dados-satisfacao/perguntas/perguntas-grafico/perguntas-grafico.component';
import { EstadosComponent } from './dados-satisfacao/estados/estados.component';
import { EstadosGraficoComponent } from './dados-satisfacao/estados/estados-grafico/estados-grafico.component';

const components = [];

@NgModule({
  imports: [ThemeModule, ConsumerRoutingModule, NgxEchartsModule, NgxChartsModule, ChartModule],
  declarations: [...routedComponents, ...components,  DadosSatisfacaoComponent, PerguntasComponent, PerguntasGraficoComponent, EstadosComponent, EstadosGraficoComponent, ],
  providers: [ PerguntaService ]
})

export class ConsumerModule {}
