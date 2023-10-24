package com.bugblogs.bugsblog.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugblogs.bugsblog.beans.Blog;

@RestController
public class BlogController {

    @GetMapping("/blogs")
    public List<Blog> getBlogs() {
        return Arrays.asList(new Blog("Long", "Long story of a night", "......verylong"));
    }

    @GetMapping("/blogs/1")
    public Blog getBlogDetails() {
        return new Blog("Public", "One Thousand and One Nightss", "one thouse story....");
    }

}
