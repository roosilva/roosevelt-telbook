package br.com.rfms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.rfms.storage.UploadDataBase;

@RestController
@RequestMapping("/service/file")
@CrossOrigin("*")
public class FileResource {
	
	@Autowired
	private UploadDataBase uploadDataBase;
	
	@PostMapping
	public void upload(@RequestParam MultipartFile file) {
		//System.out.println("Carregando: " + file.getSize()/1024/1024 + " MB");
		uploadDataBase.saveFile(file);
	}

}
