package br.com.rfms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class EstadoModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String sigla;

	@OneToMany(mappedBy="estado")
	private List<PesquisaModel> pesquisas;

	public EstadoModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<PesquisaModel> getPesquisas() {
		return this.pesquisas;
	}

	public void setPesquisas(List<PesquisaModel> pesquisas) {
		this.pesquisas = pesquisas;
	}

	public PesquisaModel addPesquisa(PesquisaModel pesquisa) {
		getPesquisas().add(pesquisa);
		pesquisa.setEstado(this);

		return pesquisa;
	}

	public PesquisaModel removePesquisa(PesquisaModel pesquisa) {
		getPesquisas().remove(pesquisa);
		pesquisa.setEstado(null);

		return pesquisa;
	}

}