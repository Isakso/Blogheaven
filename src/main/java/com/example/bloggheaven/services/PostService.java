package com.example.bloggheaven.services;

import com.example.bloggheaven.exceptions.ResourceNotFoundException;
import com.example.bloggheaven.models.Blog;
import com.example.bloggheaven.models.User;
import com.example.bloggheaven.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements PostServiceInterface{
@Autowired
private BlogRepository blogRepository;
@Autowired
private Optional<User> userRepository;
    @Override
    public List<Blog> getAllPost() {
        return blogRepository.findAll();

    }
    @Override
    public Blog getPostById(int id) {
       if(blogRepository.existsById(id)){
               Optional<Blog> existingBlog= blogRepository.findById(id);
               if(existingBlog.isPresent()){
                   return existingBlog.get();
               }
       }
   throw new ResourceNotFoundException("Blog","Id",id);
    }

    @Override
    public Blog addPost(Blog blog) {
       if(userRepository.isPresent()){

       }
       return blogRepository.save(blog);
    }
    @Override
    public Blog UpdatePostById(int id, Blog updatedBlog) {

        if (blogRepository.existsById(id)) {
            Blog existingBlog = blogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Blog", "id", id));
            existingBlog.setTitle(updatedBlog.getTitle());
            existingBlog.setAuthor(updatedBlog.getAuthor());
            existingBlog.setContent(updatedBlog.getContent());
            existingBlog.setPublicationDate(updatedBlog.getPublicationDate()
            );

        }
        return blogRepository.save(updatedBlog);
    }
    @Override
    public void DeletePostById(int id) {
        blogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Blog", "id", id));
        blogRepository.deleteById(id);

    }
}
