package com.pawel.git_app.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class OwnerDto {

    @JsonProperty("login")
    private String login;

    public OwnerDto() {
    }

    public OwnerDto(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
