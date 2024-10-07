package com.blogging.blog.controller;

import com.blogging.blog.model.Post;
import com.blogging.blog.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private Service service;

    // List all posts
    @GetMapping
    public List<Post> findAll() {
        return service.findAll();
    }

    // Find post by id
    @GetMapping("/{id}")
    public Post findById(@PathVariable Long id) {
        return service.findById(id);
    }

    // Save post
    @PostMapping
    public Post save(@RequestBody Post post) {
        return service.save(post);
    }

    // Update post
    @PutMapping("/{id}")
    public Post update(@RequestBody Post post) {
        return service.update(post);
    }

    // Delete post
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
