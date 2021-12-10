package org.generation.ensino.repository;

import java.util.List;

import org.generation.ensino.Model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{
	public List<Tema> findAllByAreaContainingIgnoreCase (String area);
}
