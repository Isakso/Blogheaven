package com.example.bloggheaven.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "Blog")

public class Blog {
    //INSERT INTO BLOGS (title, author, content, publication_date)
    //VALUES
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "blog_id", nullable = false)
        private int blogId;
        @Column(name = "title", length = 40)
        private String title;
        @Column(name = "author", nullable = false)
        private String author;
        @Column(name = "content", nullable = false)
        private String content;
        @Column(name = "publication_date", nullable = false)
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        private String publicationDate;

        public Blog(){

        }

        public Blog(String title, String content, String publicationDate){
            this.title = title;
            this.content = content;
            this.publicationDate = publicationDate;
        }

        public String getTitle() {
        return title;
        }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }
}




