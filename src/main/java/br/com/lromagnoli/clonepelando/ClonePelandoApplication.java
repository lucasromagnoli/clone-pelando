package br.com.lromagnoli.clonepelando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.lromagnoli.clonepelando.service.SocialMetaTagService;

@SpringBootApplication
public class ClonePelandoApplication{

	public static void main(String[] args) {
		SpringApplication.run(ClonePelandoApplication.class, args);
	}

	@Autowired
	SocialMetaTagService service;
		

}
