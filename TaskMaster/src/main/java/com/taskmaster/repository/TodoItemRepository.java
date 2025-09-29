package com.taskmaster.repository;
import com.taskmaster.entity.TodoItem;
import com.taskmaster.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findByUser(User user);
}