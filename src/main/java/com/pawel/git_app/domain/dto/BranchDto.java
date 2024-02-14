package com.pawel.git_app.domain.dto;

public record BranchDto(String branchName, CommitDto lastCommitSha) {
}
