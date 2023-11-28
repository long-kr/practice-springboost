package com.bugblogs.bugsblog.blog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Blog findByTitle(String title);
}
