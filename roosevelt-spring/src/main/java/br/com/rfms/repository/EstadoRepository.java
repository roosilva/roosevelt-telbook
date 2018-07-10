package br.com.rfms.repository;

import org.springframework.data.repository.Repository;

import br.com.rfms.model.EstadoModel;

public interface EstadoRepository extends Repository<EstadoModel, Integer> {
 
	EstadoModel findBySigla(String sigla);
	
	EstadoModel saveAndFlush(EstadoModel estado);
	
}
