package com.bugblogs.bugsblog.blog;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    private BlogRepository blogRepository;

    public BlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

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
