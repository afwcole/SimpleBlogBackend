package com.example.SimpleBlogBackend.exception;

public class PostNotFoundException extends  RuntimeException {
    public PostNotFoundException(String message){
        super(message);
    }
}
