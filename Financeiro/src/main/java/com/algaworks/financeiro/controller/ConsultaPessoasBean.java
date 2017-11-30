package com.algaworks.financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.financeiro.model.Pessoa;
import com.algaworks.financeiro.repository.Pessoas;
import com.algaworks.financeiro.service.CadastroPessoas;
import com.algaworks.financeiro.service.NegocioException;


@Named
@javax.faces.view.ViewScoped
public class ConsultaPessoasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pessoas pessoasRepository;
	
	private List<Pessoa> pessoas;
	
	@Inject
	private CadastroPessoas cadastro;
	
	private Pessoa pessoaSelecionada;
	
	
	public void consultar() {
		// TODO Auto-generated method stub
		
		this.pessoas=pessoasRepository.todos();
		
	}
	
	public void excluir(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.excluir(this.pessoaSelecionada);
			this.consultar();
			context.addMessage(null, new FacesMessage(
			"Lançamento excluído com sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}
	
	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	
	
	

}
