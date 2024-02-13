package com.pawel.git_app.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GitConfig {

    @Value("${github.api.endpoint.prod}")
    private String baseGithubUrl;

    public String getBaseGithubUrl() {
        return baseGithubUrl;
    }
}
