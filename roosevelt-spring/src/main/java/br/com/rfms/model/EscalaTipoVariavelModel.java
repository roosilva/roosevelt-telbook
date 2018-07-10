package br.com.rfms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="escala_tipo_variavel")
public class EscalaTipoVariavelModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descricao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="tipo_variavel_id")
	private TipoVariavelModel tipoVariavel;

	public EscalaTipoVariavelModel() {
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

	public TipoVariavelModel getTipoVariavel() {
		return this.tipoVariavel;
	}

	public void setTipoVariavel(TipoVariavelModel tipoVariavel) {
		this.tipoVariavel = tipoVariavel;
	}

}