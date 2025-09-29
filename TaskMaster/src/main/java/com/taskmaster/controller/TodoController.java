package com.taskmaster.controller;
// ... imports
import com.taskmaster.entity.User;
import com.taskmaster.service.TodoItemService;
import com.taskmaster.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TodoController {
    private final TodoItemService todoService;
    private final UserService userService;

    public TodoController(TodoItemService ts, UserService us) { this.todoService = ts; this.userService = us; }

    @GetMapping
    public String getTodos(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername()).orElseThrow();
        model.addAttribute("todos", todoService.getTodosForUser(user));
        return "todos";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String task, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername()).orElseThrow();
        todoService.addTodo(task, user);
        return "redirect:/todos";
    }

    @PostMapping("/toggle/{id}")
    public String toggleTodo(@PathVariable Long id) {
        todoService.toggleTodoStatus(id);
        return "redirect:/todos";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/todos";
    }
}