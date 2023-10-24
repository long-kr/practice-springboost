package com.bugblogs.bugsblog.beans;

public class Blog {
    private String author;
    private String name;
    private String content;

    public Blog(String author, String name, String content) {
        this.author = author;
        this.name = name;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Blog [author=" + author + ", name=" + name + ", content=" + content + "]";
    }

}
