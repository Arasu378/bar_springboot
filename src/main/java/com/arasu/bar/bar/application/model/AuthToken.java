package com.arasu.bar.bar.application.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthToken {
    @JsonProperty("Token")
    private String token;

    public AuthToken(){

    }

    public AuthToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
