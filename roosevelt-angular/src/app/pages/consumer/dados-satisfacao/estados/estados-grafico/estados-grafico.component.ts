import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'estados-grafico',
  templateUrl: './estados-grafico.component.html',
  styleUrls: ['./estados-grafico.component.scss']
})
export class EstadosGraficoComponent implements OnInit {

  siglaEstado : string;

  constructor(private activatedRoute: ActivatedRoute) { 
    this.activatedRoute.queryParams.subscribe(params => {
      let sigla = params['sigla'];
      this.siglaEstado = sigla;
    });
  }

  ngOnInit() {
  }

}
