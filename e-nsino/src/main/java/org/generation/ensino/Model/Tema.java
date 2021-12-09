package org.generation.ensino.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;


@Entity
@Table(name = "tb_temas")
public class Tema {
	
	//teste de commit
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo descrição não pode estar vazio")
	@Size (min = 3, max = 255, message = "O atributo descrição deve conter no mínimo 3 letras")
	private String descricao;
	
	@NotBlank(message = "O atributo nível não pode estar vazio")
	@Size (min = 1, max = 45, message = "O atributo nível deve conter no mínimo 3 letras")
	private String nivel;
	
	@NotBlank(message = "O atributo área não pode estar vazio")
	@Size (min = 3, max = 45, message = "O atributo area deve conter no mínimo 3 letras")
	private String area;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	
}