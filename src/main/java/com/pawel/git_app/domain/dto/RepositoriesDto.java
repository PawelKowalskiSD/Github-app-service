package com.pawel.git_app.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoriesDto {

    @JsonProperty("repository_name")
    private String repositoryName;
    @JsonProperty("owner")
    private OwnerDto owner;
    @JsonProperty("branch")
    private BranchDto branch;

    public RepositoriesDto() {
    }

    public RepositoriesDto(String repositoryName, OwnerDto owner, BranchDto branch) {
        this.repositoryName = repositoryName;
        this.owner = owner;
        this.branch = branch;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public OwnerDto getOwner() {
        return owner;
    }

    public BranchDto getBranch() {
        return branch;
    }
}
