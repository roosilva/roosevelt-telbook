package br.com.rfms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="pesquisa")
public class PesquisaModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_pesquisa")
	private Date dataPesquisa;

	private int idtns;

	@ManyToOne
	@JoinColumn(name="ano_base_id")
	private AnoBaseModel anoBase;

	@ManyToOne
	private EstadoModel estado;

	@ManyToOne
	private OperadoraModel operadora;

	@ManyToOne
	private PlanoModel plano;

	@OneToMany(mappedBy="pesquisa")
	@Cascade(CascadeType.PERSIST)
	private List<ResultadoModel> resultados;

	public PesquisaModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataPesquisa() {
		return this.dataPesquisa;
	}

	public void setDataPesquisa(Date dataPesquisa) {
		this.dataPesquisa = dataPesquisa;
	}

	public int getIdtns() {
		return this.idtns;
	}

	public void setIdtns(int idtns) {
		this.idtns = idtns;
	}

	public AnoBaseModel getAnoBase() {
		return this.anoBase;
	}

	public void setAnoBase(AnoBaseModel anoBase) {
		this.anoBase = anoBase;
	}

	public EstadoModel getEstado() {
		return this.estado;
	}

	public void setEstado(EstadoModel estado) {
		this.estado = estado;
	}

	public OperadoraModel getOperadora() {
		return this.operadora;
	}

	public void setOperadora(OperadoraModel operadora) {
		this.operadora = operadora;
	}

	public PlanoModel getPlano() {
		return this.plano;
	}

	public void setPlano(PlanoModel plano) {
		this.plano = plano;
	}

	public List<ResultadoModel> getResultados() {
		return this.resultados;
	}

	public void setResultados(List<ResultadoModel> resultados) {
		this.resultados = resultados;
	}

	public ResultadoModel addResultado(ResultadoModel resultado) {
		getResultados().add(resultado);
		resultado.setPesquisa(this);

		return resultado;
	}

	public ResultadoModel removeResultado(ResultadoModel resultado) {
		getResultados().remove(resultado);
		resultado.setPesquisa(null);

		return resultado;
	}

}