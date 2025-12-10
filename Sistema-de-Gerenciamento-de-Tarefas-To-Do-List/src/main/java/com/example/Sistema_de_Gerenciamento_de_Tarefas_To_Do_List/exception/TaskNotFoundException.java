package com.example.Sistema_de_Gerenciamento_de_Tarefas_To_Do_List.exception;

public class TaskNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TaskNotFoundException(int id) {
		super("Tarefa com id "+id+" não encontrada...");
	}
}
