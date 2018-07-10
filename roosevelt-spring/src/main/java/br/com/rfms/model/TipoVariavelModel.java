package br.com.rfms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipo_variavel")
public class TipoVariavelModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String tipo;

	@OneToMany(mappedBy="tipoVariavel")
	private List<EscalaTipoVariavelModel> escalaTipoVariavels;

	@OneToMany(mappedBy="tipoVariavel")
	private List<PerguntaModel> perguntas;

	public TipoVariavelModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<EscalaTipoVariavelModel> getEscalaTipoVariavels() {
		return this.escalaTipoVariavels;
	}

	public void setEscalaTipoVariavels(List<EscalaTipoVariavelModel> escalaTipoVariavels) {
		this.escalaTipoVariavels = escalaTipoVariavels;
	}

	public EscalaTipoVariavelModel addEscalaTipoVariavel(EscalaTipoVariavelModel escalaTipoVariavel) {
		getEscalaTipoVariavels().add(escalaTipoVariavel);
		escalaTipoVariavel.setTipoVariavel(this);

		return escalaTipoVariavel;
	}

	public EscalaTipoVariavelModel removeEscalaTipoVariavel(EscalaTipoVariavelModel escalaTipoVariavel) {
		getEscalaTipoVariavels().remove(escalaTipoVariavel);
		escalaTipoVariavel.setTipoVariavel(null);

		return escalaTipoVariavel;
	}

	public List<PerguntaModel> getPerguntas() {
		return this.perguntas;
	}

	public void setPerguntas(List<PerguntaModel> perguntas) {
		this.perguntas = perguntas;
	}

	public PerguntaModel addPergunta(PerguntaModel pergunta) {
		getPerguntas().add(pergunta);
		pergunta.setTipoVariavel(this);

		return pergunta;
	}

	public PerguntaModel removePergunta(PerguntaModel pergunta) {
		getPerguntas().remove(pergunta);
		pergunta.setTipoVariavel(null);

		return pergunta;
	}

}