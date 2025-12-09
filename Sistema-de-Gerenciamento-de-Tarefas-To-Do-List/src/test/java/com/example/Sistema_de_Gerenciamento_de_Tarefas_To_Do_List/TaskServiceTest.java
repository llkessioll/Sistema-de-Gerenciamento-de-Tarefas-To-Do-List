package com.example.Sistema_de_Gerenciamento_de_Tarefas_To_Do_List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.Sistema_de_Gerenciamento_de_Tarefas_To_Do_List.controller.TaskService;
import com.example.Sistema_de_Gerenciamento_de_Tarefas_To_Do_List.model.Task;


public class TaskServiceTest {

	@Test
	public void cadastrarUmaTarefa() {
		
		TaskService service = new TaskService();
		
		Task tarefa = service.addTask("Estudar TDD e BDD");
		
		assertNotNull(tarefa.getId());
		assertEquals("Estudar TDD e BDD", tarefa.getDescricao());
		assertFalse(tarefa.isConcluida());
		
	}
	
	@Test
	public void listarTodasAsTarefas() {
		
		TaskService service = new TaskService();
		
		service.addTask("Estudar TDD e BDD");
		service.addTask("Estudar banco de dados");
		
		List<Task> tarefas = service.getAllTasks();
		
		assertEquals(2, tarefas.size());
		assertEquals("Estudar TDD e BDD", tarefas.get(0).getDescricao());
		assertEquals("Estudar banco de dados", tarefas.get(1).getDescricao());
	}
	
	@Test
	public void editarTarefa() {
		
		TaskService service = new TaskService();
		
		Task newService = service.addTask("Estudar TDD");
		
		service.updateTask(newService.getId(), "Estudar Banco de dados");
		
		Task atualizar = service.getTaskById(newService.getId());
		
		assertEquals("Estudar Banco de dados", atualizar.getDescricao());
	}
	
	@Test
	public void removerUmaTarefa() {
		
		TaskService service = new TaskService();
		
		Task serviceUm = service.addTask("Estudar TDD e BDD");
		Task serviceDois = service.addTask("Estudar Banco de dados");
		
		service.removerTask(serviceUm.getId());
		
		List<Task> tarefas = service.getAllTasks();
	}
	
	@Test
	public void marcaUmaTarefaConcluida() {
		
		TaskService service = new TaskService();
		
		Task newService = service.addTask("Estudar TDD e BDD");
		service.completeTask(newService.getId());
		
		Task atualizado = service.getTaskById(newService.getId());
		
		assertTrue(atualizado.isConcluida());
	}
	
}
