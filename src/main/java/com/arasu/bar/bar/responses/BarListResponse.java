package com.arasu.bar.bar.responses;

import com.arasu.bar.bar.application.entities.Bar;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BarListResponse {
    @JsonProperty("IsSuccess")
    private boolean isSuccess;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Bars")
    private List<Bar> bars;
    public BarListResponse() {}

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean success) {
        isSuccess = success;
    }
}