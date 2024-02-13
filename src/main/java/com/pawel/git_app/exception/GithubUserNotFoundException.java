package com.pawel.git_app.exception;

public class GithubUserNotFoundException extends RuntimeException {

    public GithubUserNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "User not found";
    }
}
