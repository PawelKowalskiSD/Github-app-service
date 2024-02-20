package com.pawel.git_app.client.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.pawel.git_app.domain.Branch;
import com.pawel.git_app.domain.Commit;
import com.pawel.git_app.domain.Owner;
import com.pawel.git_app.domain.Repositories;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import reactor.core.publisher.Mono;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@SpringBootTest
@WireMockTest(httpPort = 8888)
public class GitServiceTest {

    @Autowired
    private GitService gitService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shoulSearchUserTest(WireMockRuntimeInfo wireMockRuntimeInfo) {
        //Given
        Repositories repositories = new Repositories("ab", new Owner("PawelKowalskiSD"), false, new Branch("aba", new Commit("231314")));
        Repositories repositories1 = new Repositories("abzxc", new Owner("PawelKowalskiSD"), false, new Branch("aba22", new Commit("231314sadad")));
        List<Repositories> reposit = new ArrayList<>();
        reposit.add(repositories);
        reposit.add(repositories1);
        JsonNode jsonNode = objectMapper.valueToTree(reposit);
        stubFor(get(urlPathMatching("/users/PawelKowalskiSD/repos"))
                .willReturn(ok()
                        .withHeader("Content-Type", "application/json")
                        .withJsonBody(jsonNode)));
        stubFor(get(urlPathMatching("/repos/PawelKowalskiSD/abzxc/branches"))
                .willReturn(ok()
                        .withHeader("Content-Type", "application/json")
                        .withJsonBody(jsonNode)));
        //When
        List<Repositories> result = gitService.searchUser("PawelKowalskiSD");
        //Then
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
    }
}