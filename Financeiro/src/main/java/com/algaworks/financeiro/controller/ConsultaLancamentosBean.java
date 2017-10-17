package com.algaworks.financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.*;
import javax.persistence.*;
import com.algaworks.financeiro.model.Lancamento;
import com.algaworks.financeiro.repository.Lancamentos;
import com.algaworks.financeiro.util.JpaUtil;

@ManagedBean
@ViewScoped
public class ConsultaLancamentosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Lancamento> lancamentos;
	
	public void consultar() {
		// TODO Auto-generated method stub

		EntityManager manager = JpaUtil.getEntityManager();
		Lancamentos lancamentos = new Lancamentos(manager);
	    this.lancamentos=lancamentos.todos();
		
		manager.close();
		
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
	
	

}
