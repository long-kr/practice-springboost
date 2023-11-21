package com.bugblogs.bugsblog.blog;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long blogId;

    @Column(nullable = false)
    @JsonProperty("blog_title")
    private String title;

    @Column(nullable = false)
    @JsonProperty("blog_content")
    private String content;

    // 0 delete, 1 public, 2 draft,
    @Column(nullable = false)
    @JsonProperty("blog_status")
    private int status;

    @Column(nullable = false)
    @JsonProperty("blog_view_number")
    private long view;

}
