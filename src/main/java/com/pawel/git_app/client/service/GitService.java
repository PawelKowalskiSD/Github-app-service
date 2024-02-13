package com.pawel.git_app.client.service;

import com.pawel.git_app.domain.Branch;
import com.pawel.git_app.domain.Repositories;
import com.pawel.git_app.exception.GithubUserNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GitService {
    private final RestClient restClient;

    public GitService(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<Repositories> searchUser(String username) {

        Repositories[] responseClient = getRepositories(username);
        String repoName = getRepositoryName(responseClient);

        Branch[] responseBranches = getBranches(username, repoName);
        Branch responseBranch = getBranch(responseBranches);

        return displayResult(responseClient, responseBranch);

    }

    private Repositories[] getRepositories(String username) {
        return restClient.get()
                .uri("/users/{username}/repos", username)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new GithubUserNotFoundException(response.getStatusCode().toString());
                })
                .body(Repositories[].class);
    }

    private static String getRepositoryName(Repositories[] responseClient) {
        String repoName = "";
        for (Repositories abc : Objects.requireNonNull(responseClient)) {
            repoName = abc.getRepositoryName();
        }
        return repoName;
    }

    private Branch[] getBranches(String username, String repoName) {
        return restClient.get()
                .uri("repos/" + username + "/{repoName}/branches", repoName)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Branch[].class);
    }

    private static Branch getBranch(Branch[] responseBranches) {
        Branch branch = new Branch();
        for (Branch bra : Objects.requireNonNull(responseBranches)) {
            branch = new Branch(bra.getName(), bra.getCommit());
        }
        return branch;
    }

    private static List<Repositories> displayResult(Repositories[] responseClient, Branch responseBranch) {
        return Arrays.stream(Objects.requireNonNull(responseClient))
                .filter(f -> !f.isFork())
                .map(s -> new Repositories(s.getRepositoryName(), s.getOwner(), s.isFork(), responseBranch))
                .collect(Collectors.toList());
    }
}
