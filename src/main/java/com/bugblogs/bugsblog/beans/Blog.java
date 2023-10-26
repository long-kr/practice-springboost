package com.bugblogs.bugsblog.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue
    private long id;
    private String author;
    private String title;
    private String content;

    public Blog(long id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getAuthorId() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Blog [authorId=" + author + ", title=" + title + ", content=" + content + "]";
    }

}
