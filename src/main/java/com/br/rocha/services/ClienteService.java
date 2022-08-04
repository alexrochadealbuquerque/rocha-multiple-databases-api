package com.br.rocha.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.rocha.repository.loja.olinda.RepositoryLojaOlinda;
import com.br.rocha.repository.loja.recife.RepositoryLojaRecife;

@Service
public class ClienteService {

	@Autowired
	private RepositoryLojaOlinda repositoryLojaOlinda;

	@Autowired
	private RepositoryLojaRecife repositoryLojaRecife;

	public List<String> getAllClientes() {

		List<String> ListaClientesOlinda = repositoryLojaOlinda.listaClientes();
		ListaClientesOlinda.add(0,"-------OLINDA-------");
		
		
		List<String> ListaClientesRecife = repositoryLojaRecife.listaClientes();
		ListaClientesRecife.add(0,"-------RECIFE-------");
		
		List<String> clientesList = new ArrayList<>();
		clientesList.addAll(ListaClientesOlinda);
		clientesList.addAll(ListaClientesRecife);

		return clientesList;
	}

}
