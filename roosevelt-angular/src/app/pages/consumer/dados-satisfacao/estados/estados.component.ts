import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'estados',
  templateUrl: './estados.component.html',
  styleUrls: ['./estados.component.scss']
})
export class EstadosComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  estado(sigla: string, code: number) {
    this.router.navigate(
      ['pages', 'consumer', 'dados-satisfacao', 'estados', 'estados-grafico'], 
      { queryParams: { sigla: sigla } }
    );
  }

}
