package com.example.Sistema_de_Gerenciamento_de_Tarefas_To_Do_List.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.Sistema_de_Gerenciamento_de_Tarefas_To_Do_List.exception.TaskNotFoundException;
import com.example.Sistema_de_Gerenciamento_de_Tarefas_To_Do_List.model.Task;

public class TaskService {

	private List<Task> tasks = new ArrayList<>();
	private int id = 1;

	public Task addTask(String descricao) {
		Task newTask = new Task(id++, descricao);
		tasks.add(newTask);
		return newTask;
	}

	// Retornando uma lista imutável
	public List<Task> getAllTasks() {
		return Collections.unmodifiableList(tasks);
	}

	public Task getTaskById(int id) {
		Optional<Task> opt = tasks.stream().filter(t -> t.getId() == id).findFirst();
		return opt.orElse(null);
	}

	//Tirado bloco if-else e utilizando os metodos privados para validar e buscar task antes de atualizar a descrição
	public void updateTask(int id, String novaDescricao) {

		validarDescricao(novaDescricao);
		
		Task task = buscarTaskOuExcecao(id);
		task.setDescricao(novaDescricao);
	}

	public void removerTask(int id) {
		tasks.removeIf(t -> t.getId() == id);
	}

	//Tirado bloco if-else para usar o metodo privado que buscar uma task ou lança uma exception
	public void completeTask(int id) {
		Task task = buscarTaskOuExcecao(id);
		task.setConcluida(true);
	}

	// Metodo para buscar tasks se não encontra lançar uma exceção personalizada
	private Task buscarTaskOuExcecao(int id) {
		return tasks.stream().filter(t -> t.getId() == id).findFirst().orElseThrow(() -> new TaskNotFoundException(id));
	}

	// Metodo para validar descrição
	private void validarDescricao(String descricao) {
		if (descricao == null || descricao.isBlank()) {
			throw new IllegalArgumentException("Descrição inválida ...");
		}
	}
}
