package com.example.SimpleBlogBackend.model;

import com.example.SimpleBlogBackend.dto.PostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
}
