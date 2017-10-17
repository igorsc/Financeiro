package com.algaworks.financeiro.repository;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.algaworks.financeiro.model.Lancamento;

public class Lancamentos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  EntityManager manager;
	
	public Lancamentos (EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Lancamento> todos() {
		TypedQuery<Lancamento> query= manager.createQuery("from Lancamento",Lancamento.class);
		return query.getResultList();
	}
	
	public void adicionar(Lancamento lancamento) {
		this.manager.persist(lancamento);
	}

}
