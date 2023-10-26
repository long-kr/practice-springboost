package com.bugblogs.bugsblog.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugblogs.bugsblog.beans.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
