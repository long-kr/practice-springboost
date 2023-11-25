package com.bugblogs.bugsblog.user;

import com.bugblogs.bugsblog.types.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotBlank(message = "User name is not valid")
    @Size(max = 50)
    private String username;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @NotEmpty(message = "Password should not be empty")
    @Size(min = 6)
    private String password;

    @NotEmpty(message = "Status cant be empty")
    @Pattern(regexp = "^[0-2]{3}&")
    private int status;

    private String pic;

    private UserRole role = UserRole.USER;

}
