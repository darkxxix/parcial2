package co.edu.usco.pw.springboot_crud01.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.usco.pw.springboot_crud01.model.Todo;
import co.edu.usco.pw.springboot_crud01.service.ITodoService;

@Controller
public class TodoController {

	@Autowired
	private ITodoService todoService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date 
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@GetMapping("/list-todos")
	public String showTodos(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("todos", todoService.getTodosByUser(name));
		// model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@GetMapping("/add-todo")
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo());
		return "todo";
	}

	@PostMapping("/add-todo")
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		todo.setUserName(getLoggedInUserName(model));
		todoService.saveTodo(todo);
		return "redirect:/list-todos";
	}

	@GetMapping("/delete-todo")
	public String deleteTodo(@RequestParam long id) {
		todoService.deleteTodo(id);
		// service.deleteTodo(id);
		return "redirect:/list-todos";
	}

	@GetMapping("/update-todo")
	public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
		Todo todo = todoService.getTodoById(id).get();
		model.put("todo", todo);
		return "todo";
	}

	@PostMapping("/update-todo")
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		todo.setUserName(getLoggedInUserName(model));
		todoService.updateTodo(todo);
		return "redirect:/list-todos";
	}

}
