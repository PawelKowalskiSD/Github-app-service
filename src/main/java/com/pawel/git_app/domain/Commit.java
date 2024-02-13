package com.pawel.git_app.domain;

public class Commit {

    private String sha;

    public Commit() {
    }

    public Commit(String sha) {
        this.sha = sha;
    }

    public String getSha() {
        return sha;
    }
}
