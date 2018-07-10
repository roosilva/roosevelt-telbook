package br.com.rfms.repository;

import org.springframework.data.repository.Repository;

import br.com.rfms.model.AnoBaseModel;

public interface AnoBaseRepository extends Repository<AnoBaseModel, Integer> {
 
	AnoBaseModel findByAnoBase(int anoBase);
	
	AnoBaseModel saveAndFlush(AnoBaseModel anoBase);
	
}
