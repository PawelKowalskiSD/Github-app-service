package com.pawel.git_app.controller;

import com.pawel.git_app.client.service.GitService;
import com.pawel.git_app.domain.Branch;
import com.pawel.git_app.domain.Commit;
import com.pawel.git_app.domain.Owner;
import com.pawel.git_app.domain.Repositories;
import com.pawel.git_app.domain.dto.BranchDto;
import com.pawel.git_app.domain.dto.CommitDto;
import com.pawel.git_app.domain.dto.OwnerDto;
import com.pawel.git_app.domain.dto.RepositoriesDto;
import com.pawel.git_app.mapper.DtoMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GitControllerTest {

    private final GitService service = mock(GitService.class);
    private final DtoMapper dto = mock(DtoMapper.class);

    @Test
    void shouldGetUserRepositories() {
        //Given
        GitController gitController = new GitController(dto, service);
        String username = "PawelKowalskiSD";
        List<Repositories> repositories = new ArrayList<>();
        repositories.add(new Repositories(
                "project-crypto-wallet2023",
                new Owner("PawelKowalskiSD"),
                false,
                new Branch("main",
                        new Commit("ff9627d2b314d02e9c2452b5afc850ca1480b542"))));
        when(service.searchUser(username)).thenReturn(repositories);
        List<RepositoriesDto> repositoriesDtos = new ArrayList<>();
        repositoriesDtos.add(new RepositoriesDto(
                "project-crypto-wallet2023",
                new OwnerDto("PawelKowalskiSD"),
                new BranchDto("main",
                        new CommitDto("ff9627d2b314d02e9c2452b5afc850ca1480b542"))));
        when(dto.mapToRepositoryDto(repositories)).thenReturn(repositoriesDtos);
        //When
        List<RepositoriesDto> result = gitController.getUserRepositories(username).getBody();
        //Then
        assertEquals("project-crypto-wallet2023", Objects.requireNonNull(result).get(0).repositoryName());
        assertEquals("PawelKowalskiSD", Objects.requireNonNull(result).get(0).owner().login());
        assertEquals("main", Objects.requireNonNull(result).get(0).branch().branchName());
        assertEquals("ff9627d2b314d02e9c2452b5afc850ca1480b542", Objects.requireNonNull(result).get(0).branch().lastCommitSha().sha());
    }
}