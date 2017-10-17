package com.algaworks.financeiro.service;

import java.io.Serializable;
import com.algaworks.financeiro.model.Pessoa;
import com.algaworks.financeiro.repository.Pessoas;

public class CadastroPessoas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Pessoas pessoas;

	public  CadastroPessoas(Pessoas pessoas) {
		// TODO Auto-generated constructor stub
		 this.pessoas= pessoas;
	}
	
	public void salvar(Pessoa pessoa) throws NegocioException{
		
		if (pessoa.getNome()==null) {
			throw new NegocioException("Campo nome da pessoa sem preencher. Informe o nome da pessoa!");
		}		
		
		this.pessoas.adicionar(pessoa);
	}

}
