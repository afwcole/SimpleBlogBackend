package com.example.SimpleBlogBackend.service.impl;

import com.example.SimpleBlogBackend.dto.PostDTO;
import com.example.SimpleBlogBackend.exception.PostNotFoundException;
import com.example.SimpleBlogBackend.model.Post;
import com.example.SimpleBlogBackend.repository.PostRepository;
import com.example.SimpleBlogBackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Boolean createNewPost(PostDTO postDTO) {
        Post newPost = new Post(postDTO);

        LocalDate currentTime = LocalDate.now();
        newPost.setCreatedAt(currentTime);
        newPost.setLastUpdated(currentTime);

        postRepository.save(newPost);
        return true;
    }

    @Override
    public PostDTO getPost(String postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Blog post does not exist"));
        return new PostDTO(post);
    }
}
