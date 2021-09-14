package com.in28minutes.business;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.data.api.TodoService;


//TodoBusinessImpl -> System Under Test (SUT)
//TodoService -> Dependency
public class TodoBusinessImpl {
	
	private TodoService todoService;
	
	
	public TodoBusinessImpl(TodoService theTodoService) {
		this.todoService = theTodoService;
	}
	
	public List<String> retrieveTodosRelatedToSpring(String user){
		List<String> allTodos = todoService.retrieveTodos(user);
		List<String> springTodos = new ArrayList<String>();
		
		for(String todo: allTodos) {
			if(todo.contains("Spring")) {
				springTodos.add(todo);
			}
		}
		return springTodos;
		
	}

}
