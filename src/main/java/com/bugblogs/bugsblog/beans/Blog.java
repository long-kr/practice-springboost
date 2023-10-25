package com.bugblogs.bugsblog.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue
    private long id;
    private long authorId;
    private String title;
    private String content;

    public Blog(long authorId, String title, String content) {
        this.authorId = authorId;
        this.title = title;
        this.content = content;
    }

    public long getAuthorId() {
        return authorId;
    }

    public String getName() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Blog [authorId=" + authorId + ", title=" + title + ", content=" + content + "]";
    }

}
