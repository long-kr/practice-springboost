package com.bugblogs.bugsblog.user;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/{id}")
    public User getUserDetails(@PathVariable long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new RuntimeException("Uer is not valid" + id);
        }

        return user.get();
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {

    }
}
