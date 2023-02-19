package com.example.SimpleBlogBackend.dto;

import java.util.Date;

public record PostDTO (
        String postId,
        String title,
        String content,
        String author,
        Date createdAt,
        Date lastUpdated
) {

}
