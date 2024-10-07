package com.blogging.blog.service;

import com.blogging.blog.model.Post;
import com.blogging.blog.repository.Repository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repository;

    // List all posts
    public List<Post> findAll() {
        return repository.findAll();
    }

    // Find post by id
    public Post findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Save post
    public Post save(Post post) {
        return repository.save(post);
    }

    // Update post
    public Post update(Post post) {
        return repository.save(post);
    }

    // Delete post
    public void delete(Long id) {
        repository.deleteById(id);
    }


}
