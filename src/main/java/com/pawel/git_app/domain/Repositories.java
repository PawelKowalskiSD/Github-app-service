package com.pawel.git_app.domain;

public record Repositories(String name, Owner owner, boolean fork, Branch branch) {
}
