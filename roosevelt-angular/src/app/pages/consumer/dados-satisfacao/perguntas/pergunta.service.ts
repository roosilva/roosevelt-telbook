import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PerguntaService {

  perguntasUrl = 'http://localhost:8091/service/pergunta';
  perguntasUrl2 = 'http://localhost:8091/service/pergunta/id/';
  perguntasUrl3 = 'http://localhost:8091/service/resultado/pergunta/';
  

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<any[]>(this.perguntasUrl);
  }

  buscarPeloId(id) {
    return this.http.get(this.perguntasUrl2.concat(id));
  }
  
  /*async listarPelaPergunta(id) : Promise<any[]> {
    return await this.http.get<any[]>(this.perguntasUrl2.concat(id)).toPromise();
  }*/

  listarPelaPergunta(id) {
    return this.http.get<any[]>(this.perguntasUrl3.concat(id));
  }
}
