package com.br.rocha.repository.loja.recife;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.rocha.entity.loja.recife.Cliente;

@Repository
public interface RepositoryLojaRecife extends JpaRepository<Cliente, Integer> {

	@Query(value = "select c.nome from cliente_recife c", nativeQuery = true)
	List<String> listaClientes();

}
