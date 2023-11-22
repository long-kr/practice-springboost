package com.bugblogs.bugsblog.user;

import java.util.List;

public interface IUserService {
    void saveUser(User user);

    User findUserByEmail(String email);

    List<User> findAllUsers();

}
