package com.bugblogs.bugsblog.blog;

import java.io.File;
import java.util.ArrayList;

import com.bugblogs.utils.ReadFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class SeedBlog {

    ObjectMapper objectMapper = new ObjectMapper();

    // Enable pretty printing for JSON output
    // objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

    public void seed() {
        ArrayList<Blog> blogs = objectMapper.readValue(new File("src/main/resources/blogs.json"),
                objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Blog.class));

        for (Blog blog : blogs) {

        }
    }
}
