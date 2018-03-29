package com.arasu.bar.bar.responses;

import com.arasu.bar.bar.application.entities.Section;
import com.arasu.bar.bar.application.entities.UserLiquor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLiquorResponse {
    @JsonProperty("IsSuccess")
    private boolean isSuccess;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("UserLiquor")
    private UserLiquor userLiquor;
    public UserLiquorResponse() {}

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean success) {
        isSuccess = success;
    }
}
