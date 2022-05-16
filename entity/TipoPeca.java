package br.com.senai.manutencaosenaiapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity(name = "TipoPeca")
@Table(name = "tipos_pecas")
public class TipoPeca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "descricao")
	@Size(max = 150, message = "O limite para de caracteres para descrição é de 150")
	@NotEmpty(message = "A descrição não pode ser nula")
	String descricao;
	
	@Transient
	public boolean isNovo() {
		return getId() == null || getId() == 0;
	}
}
