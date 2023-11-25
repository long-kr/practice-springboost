package com.bugblogs.bugsblog.user;

import java.util.ArrayList;
import java.util.List;

import com.bugblogs.bugsblog.blog.Blog;
import com.bugblogs.bugsblog.types.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class User {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable = false)
    @JsonProperty("user_name")
    private String username;

    @Column(nullable = false, unique = true)
    @JsonProperty("user_email")
    private String email;

    @Column(nullable = false)
    @JsonProperty("user_password")
    private String password;

    @Column(nullable = false)
    @JsonProperty("user_status")
    private int status;

    @JsonProperty("user_pic")
    private String pic;

    @Column(nullable = false)
    @JsonProperty("user_role")
    private UserRole role;

    public void deleteUser() {
        this.status = 0;
    }

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "blog_id")
    private List<Blog> posts = new ArrayList<>();
}
