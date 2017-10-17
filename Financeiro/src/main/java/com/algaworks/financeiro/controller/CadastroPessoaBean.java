package com.algaworks.financeiro.controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import com.algaworks.financeiro.model.Pessoa;

import com.algaworks.financeiro.repository.*;
import com.algaworks.financeiro.service.*;
import com.algaworks.financeiro.service.NegocioException;
import com.algaworks.financeiro.util.JpaUtil;

@ManagedBean
@ViewScoped
public class CadastroPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa = new Pessoa();
	

	
	public void salvar(){
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			trx.begin();
			CadastroPessoas cadastro= new CadastroPessoas(new Pessoas(manager));
			cadastro.salvar(this.pessoa);
			
			this.pessoa=new Pessoa();
			context.addMessage(null, new FacesMessage("Pessoa salva com sucesso!"));
			
			trx.commit();
			
		} catch (NegocioException e) {
			// TODO: handle exception
			trx.rollback();
			
			FacesMessage message = new FacesMessage(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, message);
		} finally {
			// TODO: handle finally clause
			manager.close();
		}
	}
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	

	
}
