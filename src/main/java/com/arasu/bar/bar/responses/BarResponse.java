package com.arasu.bar.bar.responses;


import com.arasu.bar.bar.application.entities.Bar;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BarResponse {
    @JsonProperty("IsSuccess")
    private boolean isSuccess;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Bar")
    private Bar bar;
    public BarResponse() {}

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean success) {
        isSuccess = success;
    }
}
