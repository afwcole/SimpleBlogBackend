package com.example.SimpleBlogBackend.controller;

import com.example.SimpleBlogBackend.dto.PostDTO;
import com.example.SimpleBlogBackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/blog")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<String> createNewPost(@RequestBody PostDTO newPost){
        return ResponseEntity.ok(postService.createNewPost(newPost));
    }

    @GetMapping("/post")
    public ResponseEntity<PostDTO> getPost(@RequestParam String postId){
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PutMapping("/post")
    public ResponseEntity<Boolean> updatePost(@RequestBody PostDTO updatedPost){
        return ResponseEntity.ok(postService.updatePost(updatedPost));
    }

    @DeleteMapping("/post")
    public ResponseEntity<Boolean> deletePost(@RequestParam String postId){
        return ResponseEntity.ok(postService.deletePost(postId));
    }
}
