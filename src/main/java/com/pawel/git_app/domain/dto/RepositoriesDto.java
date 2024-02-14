package com.pawel.git_app.domain.dto;

public record RepositoriesDto(String repositoryName, OwnerDto owner, BranchDto branch) {
}
