package br.com.rfms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="pergunta")
public class PerguntaModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descricao;

	private int numero;

	private String variavel;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="tipo_variavel_id")
	private TipoVariavelModel tipoVariavel;
	
	@JsonIgnore
	@OneToMany(mappedBy="pergunta")
	private List<ResultadoModel> resultados;

	public PerguntaModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getVariavel() {
		return this.variavel;
	}

	public void setVariavel(String variavel) {
		this.variavel = variavel;
	}

	public TipoVariavelModel getTipoVariavel() {
		return this.tipoVariavel;
	}

	public void setTipoVariavel(TipoVariavelModel tipoVariavel) {
		this.tipoVariavel = tipoVariavel;
	}

	public List<ResultadoModel> getResultados() {
		return this.resultados;
	}

	public void setResultados(List<ResultadoModel> resultados) {
		this.resultados = resultados;
	}

	public ResultadoModel addResultado(ResultadoModel resultado) {
		getResultados().add(resultado);
		resultado.setPergunta(this);

		return resultado;
	}

	public ResultadoModel removeResultado(ResultadoModel resultado) {
		getResultados().remove(resultado);
		resultado.setPergunta(null);

		return resultado;
	}

}