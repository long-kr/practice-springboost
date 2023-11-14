package com.bugblogs.bugsblog.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public record User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long userId,
        @JsonProperty("user_name") String userName,
        @JsonProperty("user_email") String userEmail,
        @JsonProperty("user_password") String userPassword,
        @JsonProperty("user_status") String userStatus,
        @JsonProperty("user_pic") String userPic,
        @JsonProperty("user_role") String userRole) {

    public User {

    }
}
