package com.backend.todo_list_backend.task;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public void createTask(Task task) {
        task.setCreated_at(LocalDateTime.now());
        task.setUpdated_at(LocalDateTime.now());
        taskRepository.save(task);
    }

    public void updateTask(String id, Task task) {
        Task taskbd = taskRepository
            .findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("No task was found, ID: ", id)));
        taskbd.setName(task.getName());
        taskbd.setUpdated_at(LocalDateTime.now());
        taskRepository.save(taskbd);

    }

    public void deleteTask(String id) {
        Task task = taskRepository
            .findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("No task was found, ID: ", id)));
        taskRepository.delete(task);
    }
    
}
