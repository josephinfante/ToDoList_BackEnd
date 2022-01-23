package com.backend.todo_list_backend.user;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        user.setCreated_at(LocalDateTime.now());
        user.setUpdated_at(LocalDateTime.now());
        userRepository.save(user);
    }

    public void updateUser(String id, User user) {
        User userdb = userRepository
            .findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("No user was found with ID: " +id, id)));
        userdb.setFirst_name(user.getFirst_name());
        userdb.setLast_name(user.getLast_name());
        userdb.setUpdated_at(LocalDateTime.now());
        userRepository.save(userdb);
    }

    public void deleteUser(String id) {
        User user = userRepository
            .findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("No user was found with ID: " +id, id)));
        userRepository.delete(user);
    }
}
