package com.backend.todo_list_backend.task;

import java.time.LocalDateTime;
import java.util.List;

import com.backend.todo_list_backend.user.User;

import com.backend.todo_list_backend.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public void createTask(String user_id, Task task) {
        User user = userRepository
                .findById(user_id)
                .orElseThrow(() -> new RuntimeException(String.format("No user was found with ID: " + user_id)));
        if (user != null) {
            task.setCreated_at(LocalDateTime.now());
            task.setUpdated_at(LocalDateTime.now());
            taskRepository.save(task);
            mongoTemplate.updateFirst(
                    Query.query(Criteria.where("id").is(user_id)),
                    new Update().push("tasks", task), User.class);
        }
    }

    public void updateTask(String id, Task task) {
        Task taskbd = taskRepository
            .findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("No task was found with ID: " +id, id)));
        taskbd.setName(task.getName());
        taskbd.setUpdated_at(LocalDateTime.now());
        taskRepository.save(taskbd);
    }

    public void deleteTask(String id) {
        Task task = taskRepository
            .findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("No task was found with ID: " +id, id)));
        taskRepository.delete(task);
        mongoTemplate.updateMulti(
                Query.query(Criteria.where("tasks.id").is(id)),
                new Update().pull("tasks", task), User.class);
    }
    
}
