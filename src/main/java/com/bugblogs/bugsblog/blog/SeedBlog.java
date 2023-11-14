package com.bugblogs.bugsblog.blog;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SeedBlog implements CommandLineRunner {

    private final BlogRepository blogRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    public SeedBlog(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        ArrayList<Blog> blogs = objectMapper.readValue(new File("src/main/resources/blogs.json"),
                objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Blog.class));

        for (Blog blog : blogs) {
            blogRepository.save(blog);
        }
    }
}
