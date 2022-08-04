package com.br.rocha.repository.loja.olinda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.rocha.entity.loja.olinda.Cliente;

@Repository
public interface RepositoryLojaOlinda extends JpaRepository<Cliente, Integer> {

	@Query(value = "select c.nome from cliente_olinda c", nativeQuery = true)
	List<String> listaClientes();

}
