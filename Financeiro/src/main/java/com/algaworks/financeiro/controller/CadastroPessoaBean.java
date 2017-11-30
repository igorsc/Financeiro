package com.algaworks.financeiro.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.financeiro.model.Pessoa;
import com.algaworks.financeiro.service.CadastroPessoas;
import com.algaworks.financeiro.service.NegocioException;

@Named
@javax.faces.view.ViewScoped
public class CadastroPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroPessoas cadastro;
	
	
	private Pessoa pessoa = new Pessoa();
	
	
	public void prepararCadastro(){
		if (this.pessoa==null) {
			this.pessoa = new Pessoa();
		}
	}
	

	public void salvar(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			
			cadastro.salvar(this.pessoa);
			
			this.pessoa=new Pessoa();
			context.addMessage(null, new FacesMessage("Pessoa salva com sucesso!"));
			
			
			
		} catch (NegocioException e) {
			// TODO: handle exception
			
			
			FacesMessage message = new FacesMessage(e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, message);
		} 
		
		
	}
	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	

	

	
}
