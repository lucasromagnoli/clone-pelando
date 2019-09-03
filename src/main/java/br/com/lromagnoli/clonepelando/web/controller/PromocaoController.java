package br.com.lromagnoli.clonepelando.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lromagnoli.clonepelando.domain.Categoria;
import br.com.lromagnoli.clonepelando.domain.Promocao;
import br.com.lromagnoli.clonepelando.repository.CategoriaRepository;
import br.com.lromagnoli.clonepelando.repository.PromocaoRepository;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {

	private static Logger log = LoggerFactory.getLogger(PromocaoController.class);
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private PromocaoRepository promocaoRepository;
	
	@ModelAttribute("categorias")
	private List<Categoria> getCategorias(){
		return categoriaRepository.findAll();
	}
	@GetMapping("/add")
	public String abrirCadastro() {
		
		return "promo-add";
	}
	
	@PostMapping("/save")
	public ResponseEntity<Promocao> salvarPromocao(Promocao promocao){
		promocao.setDtCadastro(LocalDateTime.now());
	
		log.info("Promocao {}", promocao.toString());
		
		promocaoRepository.save(promocao);
		
		return ResponseEntity.ok().build();
	}
}
