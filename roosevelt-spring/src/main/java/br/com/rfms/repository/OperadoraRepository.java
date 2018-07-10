package br.com.rfms.repository;

import org.springframework.data.repository.Repository;

import br.com.rfms.model.OperadoraModel;

public interface OperadoraRepository extends Repository<OperadoraModel, Integer> {
 
	OperadoraModel findByOperadora(String operadora);
	
	OperadoraModel saveAndFlush(OperadoraModel operadora);
	
}
