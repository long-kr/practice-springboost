package com.bugblogs.bugsblog.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRole());
        user.setStatus(userDto.getStatus());

        if (!userDto.getPic().isEmpty()) {
            user.setPic(userDto.getPic());
        }

        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(this::mapToUserDto).collect(Collectors.toList());
    }

    private User mapToUserDto(User user) {
        User userDto = new User();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
