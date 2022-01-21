package com.backend.todo_list_backend.task;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(Task task) {
        taskRepository.insert(task);
    }

    public void updateTask(String id, Task task) {
        Task savedTask = taskRepository.findById(id)
            .orElseThrow(()-> new RuntimeException(
                String.format("Cannot find task by ID %s", id)
            ));
        taskRepository.save(savedTask);
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
    
}
