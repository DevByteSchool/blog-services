package com.devbyteschool.blogservice.exception;

public class UserAlreadyRegisterException extends  RuntimeException {
    String message;

    public UserAlreadyRegisterException(String message) {
        this.message = message;
    }
}
