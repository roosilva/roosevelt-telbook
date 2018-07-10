import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { PerguntaService } from './pergunta.service';

@Component({
  selector: 'perguntas',
  templateUrl: './perguntas.component.html',
  styleUrls: ['./perguntas.component.scss']
})
export class PerguntasComponent implements OnInit {
  
  router: Router;

  perguntas: Array<any>;

  constructor(router: Router, private perguntaService: PerguntaService) { 
    this.router = router;
  }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.perguntaService.listar().subscribe(dados => this.perguntas = dados);
  }

  gerarGrafico(id:number, index:number) {
    this.router.navigate(
      ['pages', 'consumer', 'dados-satisfacao', 'perguntas', 'perguntas-grafico'], 
      { queryParams: { pergunta: id } }
    );
  }

}
