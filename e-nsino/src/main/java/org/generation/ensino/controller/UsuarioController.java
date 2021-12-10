package org.generation.ensino.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.ensino.Model.Tema;
import org.generation.ensino.repository.TemaRepository;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuario")
public class UsuarioController {
	
	
	@Autowired
	private usuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> GetById(@PathVariable long id){
        return usuarioRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
 
    @GetMapping("/email/{email}")
    public ResponseEntity<List<Usuario>> GetByEmail(@PathVariable String email){
        return ResponseEntity.ok(usuarioRepository.findAllBy****ContainingIgnoreCase(email));//Colocar nome do método de UsuarioRepository
    }
    
    @PostMapping
	public ResponseEntity<Usuario> post (@Valid @RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
	}
    
    @PutMapping
	public ResponseEntity<Usuario> put (@Valid @RequestBody Usuario usuario){
		return ResponseEntity.ok(usuarioRepository.save(usuario));
	}
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable long id) {
        return usuarioRepository.findById(id).map(resposta -> {
            usuarioRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }).orElse(ResponseEntity.notFound().build());
    }


}
