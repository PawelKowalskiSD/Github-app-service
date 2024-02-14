package com.pawel.git_app.mapper;

import com.pawel.git_app.domain.Branch;
import com.pawel.git_app.domain.Commit;
import com.pawel.git_app.domain.Owner;
import com.pawel.git_app.domain.Repositories;
import com.pawel.git_app.domain.dto.RepositoriesDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class DtoMapperTest {

    @InjectMocks
    private DtoMapper dtoMapper;

    @Test
    void shouldMapToRepositoryDto() {
        //Given
        List<Repositories> requestToSearchUser = new ArrayList<>();
        requestToSearchUser.add(new Repositories(
                "project-crypto-wallet2023",
                new Owner("PawelKowalskiSD"),
                false,
                new Branch("main",
                        new Commit("ff9627d2b314d02e9c2452b5afc850ca1480b542"))));
        //When
        List<RepositoriesDto> result = dtoMapper.mapToRepositoryDto(requestToSearchUser);
        //Then
//        assertEquals("project-crypto-wallet2023", result.get(0).getRepositoryName());
//        assertEquals("PawelKowalskiSD", result.get(0).getOwner().getLogin());
//        assertEquals("main", result.get(0).getBranch().getBranchName());
//        assertEquals("ff9627d2b314d02e9c2452b5afc850ca1480b542", result.get(0).getBranch().getLastCommitSha().getSha());
    }
}