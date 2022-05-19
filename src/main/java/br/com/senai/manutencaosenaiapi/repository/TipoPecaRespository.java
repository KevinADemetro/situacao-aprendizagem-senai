package br.com.senai.manutencaosenaiapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senai.manutencaosenaiapi.entity.TipoPeca;

@Repository
public interface TipoPecaRespository extends JpaRepository<TipoPeca, Integer>{

	
	@Modifying
	@Query(value = 
			"DELETE FROM TipoPeca t WHERE t.id = :id")
	void deletarPor(Integer id);
	
	@Query(value = 
			"SELECT t "
			+ "FROM TipoPeca t "
			+ "WHERE Upper(t.descricao) LIKE Upper(:descricao)")
	List<TipoPeca> listarPor(@Param("descricao") String descricao);
}
