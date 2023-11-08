package com.bugblogs.bugsblog.blog;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long blogId;
    private long authorId;
    @Column(name = "blog_title")
    private String blogTitle;
    private String blogContent;
    private String blogStatus;
    private long blogViewNumber;
    private String img;

    public Blog(long blogId, long authorId, String blogTitle, String blogContent, String blogStatus,
            long blogViewNumber, String img) {
        this.blogId = blogId;
        this.authorId = authorId;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.blogStatus = blogStatus;
        this.blogViewNumber = blogViewNumber;
        this.img = img;
    }

    public Blog() {

    }

    public long getBlogId() {
        return blogId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public String getBlogStatus() {
        return blogStatus;
    }

    public long getBlogViewNumber() {
        return blogViewNumber;
    }

    public String getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "Blog [blogId=" + blogId + ", authorId=" + authorId + ", blogTitle=" + blogTitle + ", blogContent="
                + blogContent + ", blogStatus=" + blogStatus + ", blogViewNumber=" + blogViewNumber + ", img=" + img
                + "]";
    }

}
