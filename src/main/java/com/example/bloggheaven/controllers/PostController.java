package com.example.bloggheaven.controllers;

import com.example.bloggheaven.models.Blog;
import com.example.bloggheaven.services.PostService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    @PreAuthorize("hasRole('User')")
    public ResponseEntity<List<Blog>> getAllPosts() {
        List<Blog> posts = postService.getAllPost();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/posts/{id}")
    @PreAuthorize("hasRole('User')")
    public ResponseEntity<Blog> getPostById(@PathVariable("id") int id) {
        Blog post = postService.getPostById(id);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/newpost")
    @PreAuthorize("hasRole('User')")
    public ResponseEntity<Blog> addPost(@Validated @RequestBody Blog blog) {
        Blog newPost = postService.addPost(blog);
        return ResponseEntity.ok(newPost);
    }

    @DeleteMapping("/deletepost/{id}")
    @PreAuthorize("hasRole('User')")
    public ResponseEntity<String> deletePost(@PathVariable("id") int id) {
        postService.DeletePostById(id);
        return ResponseEntity.ok("Post with ID " + id + " deleted successfully.");
    }

    @PutMapping("/updatepost/{id}")
    @PreAuthorize("hasRole('User')")
    public ResponseEntity<Blog> updatePost(@Validated @RequestBody Blog blog, @PathVariable int id) {
        Blog updatedPost = postService.UpdatePostById(id,blog);
        if (updatedPost != null) {
            return ResponseEntity.ok(updatedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
