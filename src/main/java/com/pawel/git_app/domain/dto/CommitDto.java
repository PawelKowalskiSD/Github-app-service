package com.pawel.git_app.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitDto {

    @JsonProperty("sha")
    private String sha;

    public CommitDto() {
    }

    public CommitDto(String sha) {
        this.sha = sha;
    }

    public String getSha() {
        return sha;
    }
}
