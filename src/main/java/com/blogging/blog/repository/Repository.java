package com.blogging.blog.repository;

import com.blogging.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Post, Long> {
}