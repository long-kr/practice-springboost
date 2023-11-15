package com.bugblogs.bugsblog.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_email")
    private String userEmail;

    @JsonProperty("user_password")
    private String userPassword;

    @JsonProperty("user_status")
    private int userStatus;

    @JsonProperty("user_pic")
    private String userPic;

    @JsonProperty("user_role")
    private String userRole;

    public User(long userId, String userName, String userEmail, String userPassword, int userStatus, String userPic,
            String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userStatus = userStatus;
        this.userPic = userPic;
        this.userRole = userRole;
    }

    public User() {

    }

    public void deleteUser() {
        this.userStatus = 0;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public String getUserPic() {
        return userPic;
    }

    public String getUserRole() {
        return userRole;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
                + userPassword + ", userStatus=" + userStatus + ", userPic=" + userPic + ", userRole=" + userRole + "]";
    }
}
