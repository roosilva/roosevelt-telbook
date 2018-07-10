package br.com.rfms.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.rfms.model.PerguntaModel;

public interface PerguntaRepository extends Repository<PerguntaModel, Integer> {
 
	PerguntaModel findById(int id);
	
	PerguntaModel findByNumero(int numero);
	
	List<PerguntaModel> findAll();
	
}
