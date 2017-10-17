package com.algaworks.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.algaworks.financeiro.model.Pessoa;

public class Pessoas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

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


}
