package br.com.rfms.storage;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.rfms.model.AnoBaseModel;
import br.com.rfms.model.EstadoModel;
import br.com.rfms.model.OperadoraModel;
import br.com.rfms.model.PesquisaModel;
import br.com.rfms.model.PlanoModel;
import br.com.rfms.model.ResultadoModel;
import br.com.rfms.repository.AnoBaseRepository;
import br.com.rfms.repository.EstadoRepository;
import br.com.rfms.repository.OperadoraRepository;
import br.com.rfms.repository.PerguntaRepository;
import br.com.rfms.repository.PesquisaRepository;
import br.com.rfms.repository.PlanoRepository;

@Component
public class UploadDataBase {
	
	@Autowired
	private PesquisaRepository pesquisaRepository;
	
	@Autowired
	private PlanoRepository planoRepository;
	@Autowired
	private OperadoraRepository operadoraRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private AnoBaseRepository anoBaseRepository;
	
	@Autowired
	private PerguntaRepository perguntaRepository;
	
	public void saveFile(MultipartFile file) {
		
		long tempoInicial = System.currentTimeMillis();
		int cont = 0;
		
		Scanner read;
		InputStream inputStream;
		try {
			inputStream = file.getInputStream();
			read = new Scanner(inputStream);
			String line = new String();
			
			line = read.nextLine();
			while(read.hasNext()) {
				try {
					line = read.nextLine();
					this.inserirPesquisa(line);
					//System.out.println(line);
					cont++;
					
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					Date hora = Calendar.getInstance().getTime();
					String dataFormatada = sdf.format(hora);
					
					if(cont % 1000 == 0) System.out.println(dataFormatada + " - Linha: " + cont);
				} catch (Exception e) {
					System.out.println("Erro 1: " + e);
				}
			}
		} catch (IOException e1) {
			System.out.println("Erro 2:" + e1);
		}
		
		long tempoFinal = System.currentTimeMillis();
		System.out.printf("Tempo: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
		System.out.printf("Linhas: %d", cont);
	}
	
	public void inserirPesquisa (String line) {
		
		int i = -1;
		//String linha[] = line.split(",");
		String linha[] = line.split(";");
		
		if(pesquisaRepository.findByIdtns(Integer.parseInt(linha[i+1])) != null)
			return;
		
		PesquisaModel pesquisa = new PesquisaModel();
		pesquisa.setIdtns(Integer.parseInt(linha[i+1]));
		
		PlanoModel plano = this.planoRepository.findByPlano(linha[i+2]);
		if( plano != null) {
			pesquisa.setPlano(plano);
		} else {
			plano = new PlanoModel();
			plano.setPlano(linha[i+2]);
			pesquisa.setPlano(this.planoRepository.saveAndFlush(plano));
		}
		
		OperadoraModel operadora = this.operadoraRepository.findByOperadora(linha[i+3]);
		if( operadora != null) {
			pesquisa.setOperadora(operadora);
		} else {
			operadora = new OperadoraModel();
			operadora.setOperadora(linha[i+3]);
			pesquisa.setOperadora(this.operadoraRepository.saveAndFlush(operadora));
		}
		
		EstadoModel estado = this.estadoRepository.findBySigla(linha[i+4]);
		if( estado != null) {
			pesquisa.setEstado(estado);
		} else {
			estado = new EstadoModel();
			estado.setSigla(linha[i+4]);
			pesquisa.setEstado(this.estadoRepository.saveAndFlush(estado));
		}
		
		//SimpleDateFormat formato = new SimpleDateFormat("dd/MMM/yy");
		SimpleDateFormat formato = new SimpleDateFormat("ddMMMyy");
		Date data;
		try {
			data = formato.parse(linha[i+5]);
			pesquisa.setDataPesquisa(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		AnoBaseModel anoBase = this.anoBaseRepository.findByAnoBase(Integer.parseInt(linha[i+6]));
		if( anoBase != null) {
			pesquisa.setAnoBase(anoBase);
		} else {
			anoBase = new AnoBaseModel();
			anoBase.setAnoBase(Integer.parseInt(linha[i+6]));
			pesquisa.setAnoBase(this.anoBaseRepository.saveAndFlush(anoBase));
		}
		
		pesquisa.setResultados(new ArrayList<ResultadoModel>());
		for(int j = 14; j <= 27; j++) {
			
			ResultadoModel resultado = new ResultadoModel();
			resultado.setPergunta(this.perguntaRepository.findByNumero(j));
			resultado.setPesquisa(pesquisa);
			
			if(!linha[i+j].trim().equals(""))
				resultado.setResposta(Integer.parseInt(linha[i+j]));
			else {
				resultado.setResposta(-1);
			}
			
			pesquisa.getResultados().add(resultado);
			if(j == 14) j = j + 1;
		}

		this.insertPesquisa(pesquisa);
	}
	
	private int k = 1;
	
	public void insertPesquisa(PesquisaModel p) {
		//this.pesquisaRepository.save(p);	
			
		try {
			FileWriter fw = new FileWriter("csv/pesquisa30062018.csv", true);
			BufferedWriter conexao = new BufferedWriter(fw);
			
			if(k == 1) {
				conexao.write("id,data_pesquisa,idtns,ano_base_id,estado_id,operadora_id,plano_id");
				conexao.newLine();
			}
			
			conexao.write(Integer.toString(k));
			conexao.write(",");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			conexao.write(sdf.format(p.getDataPesquisa()));
			conexao.write(",");
			conexao.write(Integer.toString(p.getIdtns()));
			conexao.write(",");
			conexao.write(Integer.toString(p.getAnoBase().getId()));
			conexao.write(",");
			conexao.write(Integer.toString(p.getEstado().getId()));
			conexao.write(",");
			conexao.write(Integer.toString(p.getOperadora().getId()));
			conexao.write(",");
			conexao.write(Integer.toString(p.getPlano().getId()));
			
			conexao.newLine();
			conexao.close();
			
			FileWriter fw2 = new FileWriter("csv/resultado30062018.csv", true);
			BufferedWriter conexao2 = new BufferedWriter(fw2);
			
			if(k == 1) {
				conexao2.write("resposta,pergunta_id,pesquisa_id");
				conexao2.newLine();
			}
			
			for(ResultadoModel r : p.getResultados()) {
				conexao2.write(Integer.toString(r.getResposta()));
				conexao2.write(",");
				conexao2.write(Integer.toString(r.getPergunta().getId()));
				conexao2.write(",");
				conexao2.write(Integer.toString(k));
				conexao2.newLine();
			}
			
			conexao2.close();
			
			k++;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
