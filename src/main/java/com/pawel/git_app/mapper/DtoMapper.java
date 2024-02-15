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
                        s.name(),
                        new OwnerDto(s.owner().login()),
                        new BranchDto(s.branch().name(),
                                new CommitDto(s.branch().commit().sha()))))
                .collect(Collectors.toList());
    }


}
