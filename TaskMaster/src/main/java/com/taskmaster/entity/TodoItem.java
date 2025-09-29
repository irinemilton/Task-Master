package com.taskmaster.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "todo_items")
public class TodoItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false) private String task;
    private boolean completed = false;
    @ManyToOne @JoinColumn(name = "user_id", nullable = false) private User user;
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}