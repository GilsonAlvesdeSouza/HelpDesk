package com.gilsonalves.helpdesk.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.gilsonalves.helpdesk.enums.PrioridadeEnum;
import com.gilsonalves.helpdesk.enums.StatusEnum;

@Document(collection = "tikets")
public class Ticket {

	@Id
	private String id;

	@DBRef(lazy = true)
	private User user;

	private Date data;

	private String titulo;

	private Integer numero;

	@Transient
	private StatusEnum status;

	private PrioridadeEnum prioridade;

	@DBRef(lazy = true)
	private User assignedUser;

	private String descricao;

	private String imagem;

	private List<AlteracoesStatus> alteracoes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public PrioridadeEnum getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeEnum prioridade) {
		this.prioridade = prioridade;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public List<AlteracoesStatus> getAlteracoes() {
		return alteracoes;
	}

	public void setAlteracoes(List<AlteracoesStatus> alteracoes) {
		this.alteracoes = alteracoes;
	}

}
