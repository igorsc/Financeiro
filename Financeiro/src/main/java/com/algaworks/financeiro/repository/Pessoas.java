package com.algaworks.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.algaworks.financeiro.model.Pessoa;

public class Pessoas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	@Inject
	public Pessoas(EntityManager manager) {
		// TODO Auto-generated constructor stub
		this.manager=manager;
	}
	
	public Pessoa porId(Long id) {
		return manager.find(Pessoa.class, id);
	}
	
	public List<Pessoa> todas() {
		TypedQuery<Pessoa> query= manager.createQuery("from Pessoa",Pessoa.class);
		return query.getResultList();
		
	}
	
	public void adicionar(Pessoa pessoa) {
		
		this.manager.persist(pessoa);
		
	}
	
	public Pessoa guardar(Pessoa pessoa) {
		return this.manager.merge(pessoa);
	}
	
	public List<Pessoa> todos() {
		TypedQuery<Pessoa> query= manager.createQuery("from Pessoa",Pessoa.class);
		return query.getResultList();
	}

	public void remover(Pessoa pessoa) {
		// TODO Auto-generated method stub
		this.manager.remove(pessoa);
		
	}


}
