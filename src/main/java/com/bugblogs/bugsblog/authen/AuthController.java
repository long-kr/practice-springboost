package com.bugblogs.bugsblog.authen;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bugblogs.bugsblog.user.IUserService;
import com.bugblogs.bugsblog.user.User;
import com.bugblogs.bugsblog.user.UserDto;
import com.bugblogs.bugsblog.util.ResponseDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AuthController {
    private final IUserService userService;

    @PostMapping("/register")
    ResponseEntity<ResponseDto<Void>> registration(@RequestBody UserDto userDto) {
        Optional<User> existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser.isPresent()) {
            ResponseDto<Void> responseDto = new ResponseDto<>("Email is already taken", null);
            return ResponseEntity.badRequest().body(responseDto);
        }

        userService.saveUser(userDto);

        ResponseDto<Void> responseDto = new ResponseDto<>("Register successful", null);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

}
