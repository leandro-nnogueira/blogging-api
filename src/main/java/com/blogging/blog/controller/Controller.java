package com.blogging.blog.controller;

import com.blogging.blog.model.Post;
import com.blogging.blog.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private Service service;

    // List all posts
    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        List<Post> posts = service.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Find post by id
    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        Post post = service.findById(id);
        if (post != null) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Save a post
    @PostMapping("/add")
    public ResponseEntity<Post> addUser(@RequestBody Post post) {
        Post newPost = service.save(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable Long id, @RequestBody Post post) {
        Post existingPost = service.findById(id);
        if (existingPost != null) {
            post.setId(id);
            Post updatedPost = service.update(post);
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete post
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
