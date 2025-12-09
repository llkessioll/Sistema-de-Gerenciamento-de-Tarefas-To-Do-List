package com.example.Sistema_de_Gerenciamento_de_Tarefas_To_Do_List.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.Sistema_de_Gerenciamento_de_Tarefas_To_Do_List.model.Task;

public class TaskService {

	private List<Task> tasks = new ArrayList<>();
	private int id = 1;
	
	public Task addTask(String descricao) {
		Task newTask = new Task(id++, descricao);
		tasks.add(newTask);
		return newTask;
	}
	
	public List<Task> getAllTasks(){
		return tasks;
	}
	
	public Task getTaskById(int id) {
		 Optional<Task> opt = tasks.stream().filter(t -> t.getId() == id).findFirst();
	     return opt.orElse(null);
	}
	
	public void updateTask(int id, String novaDescricao) {
		
		Task alterar = getTaskById(id);
		
		if( alterar != null) {
			alterar.setDescricao(novaDescricao);
		}else {
			throw new IllegalArgumentException("Task não encontrada");
		}
	}
	
	public void removerTask(int id) {
		tasks.removeIf(t -> t.getId() == id);
	}
	
	public void completeTask(int id) {
		Task task = getTaskById(id);
		
		if(task != null) {
			task.setConcluida(true);
		}else {
			throw new IllegalArgumentException("Task não encontrada");
		}
	}
	
}
