package com.pawel.git_app.client.service;

import com.pawel.git_app.domain.Branch;
import com.pawel.git_app.domain.Commit;
import com.pawel.git_app.domain.Owner;
import com.pawel.git_app.domain.Repositories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@SpringBootTest
public class GitServiceTest {

    @Autowired
    private GitService gitService;

    @MockBean
    private WebClient webClient;


    @BeforeEach
    void setUp() {
        var requestHeadersUriSpec = mock(RequestHeadersUriSpec.class);
        var requestHeadersSpec = mock(WebClient.RequestHeadersSpec.class);
        WebClient.ResponseSpec responseSpec = mock(WebClient.ResponseSpec.class);

        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString(), any(Object[].class))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.accept(any(MediaType.class))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
    }

    @Test
    void shoulSearchUserTest() {
        //Given
        Repositories[] repositories = {
                new Repositories("Books-vaadin-test",
                        new Owner("PawelKowalskiSD"),
                        false,
                        new Branch("main",
                                new Commit("e73b9989923155f5720b85c7706e64e50bc6756e")))};

        when(webClient.get()
                .uri("/users/{username}/repos", "PawelKowalskiSD")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Repositories[].class))
                .thenReturn(Mono.just(repositories));

        Branch[] branches = {
                new Branch("main",
                        new Commit("e73b9989923155f5720b85c7706e64e50bc6756e"))};

        when(webClient.get()
                .uri("repos/testUser/{repoName}/branches", "Books-vaadin-test")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Branch[].class))
                .thenReturn(Mono.just(branches));

        //When
        List<Repositories> result = gitService.searchUser("PawelKowalskiSD");
        //Then
        assertEquals("Books-vaadin-test", result.get(0).getRepositoryName());
        assertEquals("PawelKowalskiSD", result.get(0).getOwner().getLogin());
        assertFalse(result.get(0).isFork());
        assertEquals("main", result.get(0).getBranch().getName());
        assertEquals("e73b9989923155f5720b85c7706e64e50bc6756e", result.get(0).getBranch().getCommit().getSha());
    }
}