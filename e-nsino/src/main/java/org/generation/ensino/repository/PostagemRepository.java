package org.generation.ensino.repository;

import java.util.List;

import org.generation.ensino.Model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	public List<Postagem> findAllByTextoContainingIgnoreCase(String texto);
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	public List<Postagem> findAllByDataContainingIgnoreCase(String data);
	public List<Postagem> findAllByFotoContainingIgnoreCase(String foto);

    
}