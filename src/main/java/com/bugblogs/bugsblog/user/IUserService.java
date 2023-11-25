package com.bugblogs.bugsblog.user;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    void saveUser(UserDto userDto);

    Optional<User> findUserByEmail(String email);

    List<UserDto> findAllUsers();

}
