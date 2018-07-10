package br.com.rfms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="operadora")
public class OperadoraModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String operadora;

	@OneToMany(mappedBy="operadora")
	private List<PesquisaModel> pesquisas;

	public OperadoraModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperadora() {
		return this.operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public List<PesquisaModel> getPesquisas() {
		return this.pesquisas;
	}

	public void setPesquisas(List<PesquisaModel> pesquisas) {
		this.pesquisas = pesquisas;
	}

	public PesquisaModel addPesquisa(PesquisaModel pesquisa) {
		getPesquisas().add(pesquisa);
		pesquisa.setOperadora(this);

		return pesquisa;
	}

	public PesquisaModel removePesquisa(PesquisaModel pesquisa) {
		getPesquisas().remove(pesquisa);
		pesquisa.setOperadora(null);

		return pesquisa;
	}

}