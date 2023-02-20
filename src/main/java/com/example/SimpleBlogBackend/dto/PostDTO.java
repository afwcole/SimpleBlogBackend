package com.example.SimpleBlogBackend.dto;

import com.example.SimpleBlogBackend.model.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class PostDTO {
    private String postId;
    private String title;
    private String content;
    private String author;
    private LocalDate createdAt;
    private LocalDate lastUpdated;

    public PostDTO(Post post){
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
        this.createdAt = post.getCreatedAt();
        this.lastUpdated = post.getLastUpdated();
    }
}
