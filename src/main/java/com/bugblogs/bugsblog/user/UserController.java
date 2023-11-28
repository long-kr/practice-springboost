package com.bugblogs.bugsblog.user;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bugblogs.bugsblog.util.ResponseDto;

@RestController
public class UserController {
    private IUserRepository userRepository;
    private IUserService userService;

    public UserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    ResponseEntity<ResponseDto<List<UserDto>>> getUsers() {
        ResponseDto<List<UserDto>> responseDto = new ResponseDto<>("Register successful", userService.findAllUsers());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/users/{id}")
    public User getUserDetails(@PathVariable long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new RuntimeException("Uer is not valid" + id);
        }

        return user.get();
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new RuntimeException("User is not valid" + id);
        }

        user.get().deleteUser();
    }
}
