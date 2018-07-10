package br.com.rfms.repository;

import org.springframework.data.repository.Repository;

import br.com.rfms.model.PlanoModel;

public interface PlanoRepository extends Repository<PlanoModel, Integer> {
 
	PlanoModel findByPlano(String plano);
	
	PlanoModel saveAndFlush(PlanoModel plano);
	
}
