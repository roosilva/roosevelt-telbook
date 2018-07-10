package br.com.rfms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ano_base")
public class AnoBaseModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="ano_base")
	private int anoBase;

	@OneToMany(mappedBy="anoBase")
	private List<PesquisaModel> pesquisas;

	public AnoBaseModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnoBase() {
		return this.anoBase;
	}

	public void setAnoBase(int anoBase) {
		this.anoBase = anoBase;
	}

	public List<PesquisaModel> getPesquisas() {
		return this.pesquisas;
	}

	public void setPesquisas(List<PesquisaModel> pesquisas) {
		this.pesquisas = pesquisas;
	}

	public PesquisaModel addPesquisa(PesquisaModel pesquisa) {
		getPesquisas().add(pesquisa);
		pesquisa.setAnoBase(this);

		return pesquisa;
	}

	public PesquisaModel removePesquisa(PesquisaModel pesquisa) {
		getPesquisas().remove(pesquisa);
		pesquisa.setAnoBase(null);

		return pesquisa;
	}

}