package br.com.senai.manutencaosenaiapi.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.common.base.Preconditions;

import br.com.senai.manutencaosenaiapi.entity.Tecnico;
import br.com.senai.manutencaosenaiapi.entity.TipoPeca;
import br.com.senai.manutencaosenaiapi.repository.TipoPecaRespository;

@Service
@Validated
public class TipoPecaService {
	
	@Autowired
	TipoPecaRespository repository;
	
	public TipoPeca inserir(@Valid
			@NotNull(message = "O tipo peça não pode ser nulo")
			TipoPeca novoTipoPeca) {
		
		TipoPeca tipoPecaSalva = this.repository.save(novoTipoPeca);
		return tipoPecaSalva;
	}
	
	public TipoPeca alterar(@Valid
			@NotNull(message = "O tipo peça não pode ser nulo")
			TipoPeca tipoPecaSalva) {
		
		Preconditions.checkArgument(!tipoPecaSalva.isNovo(), 
				"O tipo de peça ainda não foi inserido");
		TipoPeca tipoPecaAtualizada = repository.save(tipoPecaSalva);
		return tipoPecaAtualizada;
	}
	
	public List<TipoPeca> listarPor(
			@NotEmpty(message = "O nome para busca não pode ser nulo")
			@NotBlank(message = "Não pode haver espaços antes do nome")
			String descricao){
		return repository.listarPor("%" + descricao + "%");		
	}
	
	@Transactional
	public void removerPor(
			@NotNull(message = "O id de exclusão não pode ser nulo")
			@Min(value = 1, message = "O id deve ser maior que zero")
			Integer id) {
		this.repository.deletarPor(id);
	}
	
	public TipoPeca buscarPor(Integer id) {
		return repository.findById(id).get();
	}
}
