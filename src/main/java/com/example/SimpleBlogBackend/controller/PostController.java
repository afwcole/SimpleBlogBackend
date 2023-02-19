package com.example.SimpleBlogBackend.controller;

import com.example.SimpleBlogBackend.dto.PostDTO;
import com.example.SimpleBlogBackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/blog")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<Boolean> createNewPost(@RequestBody PostDTO newPost){
        return ResponseEntity.ok(postService.createNewPost(newPost));
    }

    @GetMapping("/post")
    public ResponseEntity<PostDTO> getPost(@RequestParam String postId){
        return ResponseEntity.ok(postService.getPost(postId));
    }
}
