package br.com.rfms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rfms.model.PerguntaModel;
import br.com.rfms.model.ResultadoModel;
import br.com.rfms.repository.PerguntaRepository;
import br.com.rfms.repository.ResultadoRepository;

@CrossOrigin(origins  = "http://localhost:4200")

@RestController
@RequestMapping("/service")
public class PerguntaService {
	 
	@Autowired
	private PerguntaRepository perguntaRepository;
	
	@Autowired
	private ResultadoRepository resultadoRepository; 
 
	public PerguntaModel buscarPeloId(int id){
		return this.perguntaRepository.findById(id);
	}
	
	public PerguntaModel buscarPeloNumero(int numero){
		return this.perguntaRepository.findByNumero(numero);
	}
	
	@RequestMapping(value="/pergunta/{codigo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PerguntaModel buscar(@PathVariable("codigo") Integer codigo){		
		
		PerguntaModel pm = this.perguntaRepository.findByNumero(codigo);
		
		pm.setResultados(null);
		//pm.getTipoVariavel().setEscalaTipoVariavels(null);
		pm.getTipoVariavel().setPerguntas(null);
		
		return pm;
	}
	
	@RequestMapping(value="/pergunta/id/{codigo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PerguntaModel buscarPeloId(@PathVariable("codigo") Integer codigo){		
		
		PerguntaModel pm = this.perguntaRepository.findById(codigo);
		return pm;
	}
	
	@RequestMapping(value="/pergunta", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<PerguntaModel> consultar(){
 
		List<PerguntaModel> pm = this.perguntaRepository.findAll();
		return pm;
	}
	
	@RequestMapping(value="/resultado/pergunta/{codigo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<ResultadoModel> buscarResultadoPelaPergunta(@PathVariable("codigo") Integer codigo){		
		
		PerguntaModel pm = this.perguntaRepository.findById(codigo);
		
		//long tempoInicial = System.currentTimeMillis();
		List<ResultadoModel> rm = resultadoRepository.findByPergunta(pm);
		//long tempoFinal = System.currentTimeMillis();
		//System.out.printf("Tempo: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
		
		return rm;
	}
 
}
