package com.example.SimpleBlogBackend.model;

import com.example.SimpleBlogBackend.dto.PostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    private String postId;
    private String title;
    @Column(columnDefinition="TEXT")
    private String content;
    private String author;
    private LocalDate createdAt;
    private LocalDate lastUpdated;

    public Post(PostDTO postDTO){
        this.postId = postDTO.getPostId();
        this.title = postDTO.getTitle();
        this.content = postDTO.getContent();
        this.author = postDTO.getAuthor();
        this.createdAt = postDTO.getCreatedAt();
        this.lastUpdated = postDTO.getLastUpdated();
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
