import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NbThemeService } from '@nebular/theme';

import { PerguntaService } from '../pergunta.service';

@Component({
  selector: 'perguntas-grafico',
  templateUrl: './perguntas-grafico.component.html',
  styleUrls: ['./perguntas-grafico.component.scss']
})
export class PerguntasGraficoComponent implements OnInit {

  idPergunta : number;
  descPergunta : string ;
  objPergunta: Array<any>;

  resultados: Array<any>;
  total : number;

  options: any = {};
  themeSubscription: any;

  constructor(private theme: NbThemeService, private activatedRoute: ActivatedRoute, private perguntaService: PerguntaService) {
    this.activatedRoute.queryParams.subscribe(params => {
      let id = params['pergunta'];
      this.idPergunta = id;
    });
  }

  ngOnInit() {
    this.buscarResultados(this.idPergunta);
    this.buscarPerguntaPeloId(this.idPergunta);
  }

  /*async gerar() {
    this.perguntas = await this.perguntaService.listarPelaPergunta(this.idPergunta);
  }*/

  buscarPerguntaPeloId(id) {
    this.perguntaService.buscarPeloId(id).subscribe(data => {
      this.objPergunta = Object.values(data);
      this.descPergunta = this.objPergunta[1];
    });
  }

  buscarResultados(id) {
    this.perguntaService.listarPelaPergunta(id).subscribe(dados => {
      this.resultados = dados;
      
      /*let cont : number[] =  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
      for(let i : number = 0; i<cont.length; i++) {
        for(let j : number = 0; j<this.resultados.length; j++) {
          if(this.resultados[j].resposta == i) {
            cont[i] = cont[i] + 1;
          }
        }
      }*/

      let cont : number[] =  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
      for(let k : number = 0; k<this.resultados.length; k++) {
          if(this.resultados[k].resposta >=0 && this.resultados[k].resposta <= 10)
            cont[this.resultados[k].resposta]++;
      }

      this.total = cont.reduce(function(total, numero) {
        return total + numero;
      }, 0);
      this.ngAfterViewInitMy(cont);
    });
  }

  ngAfterViewInitMy(cont) {
    this.themeSubscription = this.theme.getJsTheme().subscribe(config => {

      const colors = config.variables;
      const echarts: any = config.variables.echarts;

      let legendData: string[];
      let seriesData: object[];
      if(cont[0] == 0 && cont[10] == 0) {
        legendData = ['Sim', 'Não'];
        seriesData = [
          { value: cont[1], name: 'Sim' },
          { value: cont[2], name: 'Não' },
        ];
      }
      else {
        legendData = ['Nota 0', 'Nota 1', 'Nota 2', 'Nota 3', 'Nota 4', 'Nota 5', 'Nota 6', 'Nota 7', 'Nota 8', 'Nota 9', 'Nota 10'];
        seriesData = [
          { value: cont[0], name: 'Nota 0' },
          { value: cont[1], name: 'Nota 1' },
          { value: cont[2], name: 'Nota 2' },
          { value: cont[3], name: 'Nota 3' },
          { value: cont[4], name: 'Nota 4' },
          { value: cont[5], name: 'Nota 5' },
          { value: cont[6], name: 'Nota 6' },
          { value: cont[7], name: 'Nota 7' },
          { value: cont[8], name: 'Nota 8' },
          { value: cont[9], name: 'Nota 9' },
          { value: cont[10], name: 'Nota 10' }
        ];
      }

      this.options = {
        backgroundColor: echarts.bg,
        color: [colors.warningLight, colors.infoLight, colors.dangerLight, colors.successLight, colors.primaryLight],
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)',
        },
        legend: {
          orient: 'vertical',
          left: 'left',
          data: legendData,
          textStyle: {
            color: echarts.textColor,
          },
        },
        series: [
          {
            name: 'Valores computados',
            type: 'pie',
            radius: '80%',
            center: ['50%', '50%'],
            data: seriesData,
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: echarts.itemHoverShadowColor,
              },
            },
            label: {
              normal: {
                textStyle: {
                  color: echarts.textColor,
                },
              },
            },
            labelLine: {
              normal: {
                lineStyle: {
                  color: echarts.axisLineColor,
                },
              },
            },
          },
        ],
      };
    });
  }

  ngOnDestroy(): void {
    this.themeSubscription.unsubscribe();
  }
}
