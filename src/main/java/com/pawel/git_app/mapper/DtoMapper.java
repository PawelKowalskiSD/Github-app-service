package com.pawel.git_app.mapper;

import com.pawel.git_app.domain.Repositories;
import com.pawel.git_app.domain.dto.BranchDto;
import com.pawel.git_app.domain.dto.CommitDto;
import com.pawel.git_app.domain.dto.OwnerDto;
import com.pawel.git_app.domain.dto.RepositoriesDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DtoMapper {
    public List<RepositoriesDto> mapToRepositoryDto(List<Repositories> repositories) {
        return repositories.stream()
                .map(s -> new RepositoriesDto(
                        s.getRepositoryName(),
                        new OwnerDto(s.getOwner().getLogin()),
                        new BranchDto(s.getBranch().getName(),
                                new CommitDto(s.getBranch().getCommit().getSha()))))
                .collect(Collectors.toList());
    }


}
