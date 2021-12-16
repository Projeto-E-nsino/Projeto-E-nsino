package org.generation.ensino.controller;

import java.util.List;

import org.generation.ensino.model.Postagem;
import org.generation.ensino.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository postRepository;
	
	//Retornar todas as postagens
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(postRepository.findAll());
	}
	
	//Retornar postagem por id
	@GetMapping("/{id}")
    public ResponseEntity<Postagem> GetById(@PathVariable long id){
    	return postRepository.findById(id)
    			.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
	
	//Retornar uma postagem por titulo
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(postRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	//Popular a tabela
	@PostMapping
	public ResponseEntity<Postagem> postPostagem (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(postagem));
	}
	
	//Atualizar valores a tabela
	 @PutMapping
	 public ResponseEntity<Postagem> putPostagem (@RequestBody Postagem postagem){
		return ResponseEntity.ok(postRepository.save(postagem));
	 }
	 
	 //Deletando itens da tabela por id
	 @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteRepository(@PathVariable long id) {
	        return postRepository.findById(id).map(resposta -> {
	            postRepository.deleteById(id);
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	        }).orElse(ResponseEntity.notFound().build());
	    }
	}