package com.example.SimpleBlogBackend.service.impl;

import com.example.SimpleBlogBackend.dto.PostDTO;
import com.example.SimpleBlogBackend.exception.PostNotFoundException;
import com.example.SimpleBlogBackend.model.Post;
import com.example.SimpleBlogBackend.repository.PostRepository;
import com.example.SimpleBlogBackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream().map(PostDTO::new).toList();
    }

    @Override
    public Boolean updatePost(PostDTO updatedPostDTO) {
        if (!postRepository.existsById(updatedPostDTO.getPostId()))
            throw new PostNotFoundException("This post does not exist");

        Post updatedPost = new Post(updatedPostDTO);
        updatedPost.setLastUpdated(LocalDate.now());
        postRepository.save(updatedPost);

        return true;
    }

    @Override
    public Boolean deletePost(String postId) {
        if (!postRepository.existsById(postId))
            throw new PostNotFoundException("This post does not exist");
        postRepository.deleteById(postId);
        return true;
    }
}
