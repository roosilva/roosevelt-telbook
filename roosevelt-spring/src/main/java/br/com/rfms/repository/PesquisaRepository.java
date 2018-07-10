package br.com.rfms.repository;

import org.springframework.data.repository.Repository;

import br.com.rfms.model.PesquisaModel;

public interface PesquisaRepository extends Repository<PesquisaModel, Integer> {
 
	void save(PesquisaModel pesquisa);
	
	PesquisaModel findByIdtns(int idtns);
	
}
