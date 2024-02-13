package com.pawel.git_app.domain;

public class Branch {

    private String name;
    private Commit commit;

    public Branch(String name, Commit commit) {
        this.name = name;
        this.commit = commit;
    }

    public Branch() {
    }

    public String getName() {
        return name;
    }

    public Commit getCommit() {
        return commit;
    }
}
