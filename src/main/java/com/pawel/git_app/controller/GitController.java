package com.pawel.git_app.controller;

import com.pawel.git_app.domain.dto.RepositoriesDto;
import com.pawel.git_app.mapper.DtoMapper;
import com.pawel.git_app.client.service.GitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/git")
public class GitController {

    private final DtoMapper dtoMapper;
    private final GitService gitService;

    public GitController(DtoMapper dtoMapper, GitService gitService) {
        this.dtoMapper = dtoMapper;
        this.gitService = gitService;
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<List<RepositoriesDto>> getUserRepositories(@PathVariable String username) {
        return ResponseEntity.ok().body(dtoMapper.mapToRepositoryDto(gitService.searchUser(username)));
    }
}
