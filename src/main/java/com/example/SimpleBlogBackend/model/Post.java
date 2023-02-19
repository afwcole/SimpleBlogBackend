package com.example.SimpleBlogBackend.model;

import com.example.SimpleBlogBackend.dto.PostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date createdAt;
    private Date lastUpdated;

    public Post(PostDTO postDTO){
        this.postId = postDTO.postId();
        this.title = postDTO.title();
        this.content = postDTO.content();
        this.author = postDTO.author();
        this.createdAt = postDTO.createdAt();
        this.lastUpdated = postDTO.lastUpdated();
    }
}
