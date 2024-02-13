package com.pawel.git_app.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchDto {

    @JsonProperty("branch_name")
    private String branchName;
    @JsonProperty("last_commit")
    private CommitDto lastCommitSha;

    public BranchDto() {
    }

    public BranchDto(String branchName, CommitDto lastCommitSha) {
        this.branchName = branchName;
        this.lastCommitSha = lastCommitSha;
    }

    public String getBranchName() {
        return branchName;
    }

    public CommitDto getLastCommitSha() {
        return lastCommitSha;
    }
}
