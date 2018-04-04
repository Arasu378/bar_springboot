package com.arasu.bar.bar.responses;

import com.arasu.bar.bar.application.entities.Bar;
import com.arasu.bar.bar.application.entities.Distributor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DistributorResponse {
    @JsonProperty("IsSuccess")
    private boolean isSuccess;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Distributor")
    private Distributor distributor;
    public DistributorResponse() {}

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean success) {
        isSuccess = success;
    }
}
