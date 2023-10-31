package com.bugblogs.bugsblog.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bugblogs.bugsblog.beans.Blog;

@RestController
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/blogs")
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    @GetMapping("/blogs/{id}")
    public Blog getBlogDetails(@PathVariable long id) {
        Optional<Blog> blog = blogRepository.findById(id);

        if (blog.isEmpty()) {
            throw new RuntimeException("Blog cannot find: " + id);
        }

        return blog.get();
    }

    @PostMapping("/blogs")
    public void createBlog(@RequestBody Blog blog) {
        blogRepository.save(blog);
    }

    @PutMapping("/blogs/{id}")
    public void updateBlog(@PathVariable long id, @RequestBody Blog blog) {
        blogRepository.save(blog);
    }

    @DeleteMapping("/blogs/{id}")
    public void deleteBlog(@PathVariable long id) {
        blogRepository.deleteById(id);
    }

}
