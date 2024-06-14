package com.example.bloggheaven.services;

import com.example.bloggheaven.models.Blog;

import java.util.List;

public interface PostServiceInterface {
    List<Blog> getAllPost();
    Blog getPostById(int id);
    Blog addPost(Blog blog);

    Blog UpdatePostById(int id, Blog blog);

  void DeletePostById(int id);



}
