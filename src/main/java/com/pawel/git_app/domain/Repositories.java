package com.pawel.git_app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repositories {
    @JsonProperty("name")
    private String repositoryName;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("fork")
    private boolean fork;
    @JsonProperty("branch")
    private Branch branch;

    public Repositories() {
    }

    public Repositories(String repositoryName, Owner owner, boolean fork, Branch branch) {
        this.repositoryName = repositoryName;
        this.owner = owner;
        this.fork = fork;
        this.branch = branch;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public Owner getOwner() {
        return owner;
    }

    public boolean isFork() {
        return fork;
    }

    public Branch getBranch() {
        return branch;
    }
}
