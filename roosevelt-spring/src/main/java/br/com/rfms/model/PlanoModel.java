package br.com.rfms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="plano")
public class PlanoModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String plano;

	@OneToMany(mappedBy="plano")
	private List<PesquisaModel> pesquisas;

	public PlanoModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlano() {
		return this.plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public List<PesquisaModel> getPesquisas() {
		return this.pesquisas;
	}

	public void setPesquisas(List<PesquisaModel> pesquisas) {
		this.pesquisas = pesquisas;
	}

	public PesquisaModel addPesquisa(PesquisaModel pesquisa) {
		getPesquisas().add(pesquisa);
		pesquisa.setPlano(this);

		return pesquisa;
	}

	public PesquisaModel removePesquisa(PesquisaModel pesquisa) {
		getPesquisas().remove(pesquisa);
		pesquisa.setPlano(null);

		return pesquisa;
	}

}