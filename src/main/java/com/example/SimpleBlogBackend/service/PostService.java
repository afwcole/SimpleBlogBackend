package com.example.SimpleBlogBackend.service;

import com.example.SimpleBlogBackend.dto.PostDTO;

import java.util.List;

public interface PostService {
    Boolean createNewPost(PostDTO postDTO);

    PostDTO getPost(String postId);

    List<PostDTO> getAllPosts();

    Boolean updatePost(PostDTO postDTO);

    Boolean deletePost(String postId);
}
