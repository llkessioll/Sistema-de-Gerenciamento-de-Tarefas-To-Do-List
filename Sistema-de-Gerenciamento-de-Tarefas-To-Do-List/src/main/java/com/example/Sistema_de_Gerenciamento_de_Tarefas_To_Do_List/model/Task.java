package com.example.Sistema_de_Gerenciamento_de_Tarefas_To_Do_List.model;

public class Task {

	private Integer id;
	private String descricao;
	private boolean concluida;
	
	public Task() {
		
	}
	
	public Task(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
		this.concluida = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}
	
}
