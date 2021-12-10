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
@RequestMapping("/tema")
public class TemaController {
	
	@Autowired
	private TemaRepository temaRepository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> getAll(){
		return ResponseEntity.ok(temaRepository.findAll());
	}
	
    @GetMapping("/{id}")
    public ResponseEntity<Tema> GetById(@PathVariable long id){
        return temaRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
 
    @GetMapping("/area/{area}")
    public ResponseEntity<List<Tema>> GetByArea (@PathVariable String area){
        return ResponseEntity.ok(temaRepository.findAllByAreaContainingIgnoreCase(area));
    }
    
    @PostMapping
	public ResponseEntity<Tema> post (@Valid @RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
	}
    
    @PutMapping
	public ResponseEntity<Tema> put (@Valid @RequestBody Tema tema){
		return ResponseEntity.ok(temaRepository.save(tema));
	}
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable long id) {
        return temaRepository.findById(id).map(resposta -> {
            temaRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
