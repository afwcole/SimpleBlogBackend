package com.example.SimpleBlogBackend.service.impl;

import com.example.SimpleBlogBackend.dto.PostDTO;
import com.example.SimpleBlogBackend.model.Post;
import com.example.SimpleBlogBackend.repository.PostRepository;
import com.example.SimpleBlogBackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Boolean createNewPost(PostDTO postDTO) {
        Post newPost = new Post(postDTO);
        postRepository.save(newPost);
        return true;
    }
}
