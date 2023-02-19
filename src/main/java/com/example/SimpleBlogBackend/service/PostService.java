package com.example.SimpleBlogBackend.service;

import com.example.SimpleBlogBackend.dto.PostDTO;

public interface PostService {
    Boolean createNewPost(PostDTO postDTO);
}
