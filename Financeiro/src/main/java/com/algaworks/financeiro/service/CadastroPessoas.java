package com.algaworks.financeiro.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.financeiro.model.Pessoa;
import com.algaworks.financeiro.repository.Pessoas;
import com.algaworks.financeiro.util.Transactional;

public class CadastroPessoas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pessoas pessoas;

	
	@Transactional
	public void salvar(Pessoa pessoa) throws NegocioException{
		
		if (pessoa.getNome()==null) {
			throw new NegocioException("Campo nome da pessoa sem preencher. Informe o nome da pessoa!");
		}		
		
		this.pessoas.guardar(pessoa);
	}


	@Transactional
	public void excluir(Pessoa pessoa) throws NegocioException {
		// TODO Auto-generated method stub
		pessoa = this.pessoas.porId(pessoa.getId());
		
		this.pessoas.remover(pessoa);
		
	}

}
