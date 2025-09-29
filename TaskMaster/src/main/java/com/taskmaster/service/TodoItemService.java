package com.taskmaster.service;
import com.taskmaster.entity.TodoItem;
import com.taskmaster.entity.User;
import com.taskmaster.repository.TodoItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoItemService {
    private final TodoItemRepository todoRepo;
    public TodoItemService(TodoItemRepository r) { this.todoRepo = r; }
    public List<TodoItem> getTodosForUser(User user) { return todoRepo.findByUser(user); }
    public void addTodo(String task, User user) {
        TodoItem newItem = new TodoItem();
        newItem.setTask(task);
        newItem.setUser(user);
        todoRepo.save(newItem);
    }
    public void toggleTodoStatus(Long id) {
        TodoItem item = todoRepo.findById(id).orElseThrow();
        item.setCompleted(!item.isCompleted());
        todoRepo.save(item);
    }
    public void deleteTodo(Long id) { todoRepo.deleteById(id); }
}