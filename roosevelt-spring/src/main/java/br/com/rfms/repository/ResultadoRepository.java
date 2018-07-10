package br.com.rfms.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import br.com.rfms.model.PerguntaModel;
import br.com.rfms.model.ResultadoModel;

public interface ResultadoRepository extends Repository<ResultadoModel, Integer> {
 
	void save(ResultadoModel resultado);
	
	List<ResultadoModel> findByPergunta(PerguntaModel pergunta);
	
}
