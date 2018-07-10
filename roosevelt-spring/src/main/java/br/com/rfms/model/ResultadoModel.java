package br.com.rfms.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="resultado")
public class ResultadoModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int resposta;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private PesquisaModel pesquisa;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private PerguntaModel pergunta;

	public ResultadoModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getResposta() {
		return this.resposta;
	}

	public void setResposta(int resposta) {
		this.resposta = resposta;
	}

	public PesquisaModel getPesquisa() {
		return this.pesquisa;
	}

	public void setPesquisa(PesquisaModel pesquisa) {
		this.pesquisa = pesquisa;
	}

	public PerguntaModel getPergunta() {
		return this.pergunta;
	}

	public void setPergunta(PerguntaModel pergunta) {
		this.pergunta = pergunta;
	}

}