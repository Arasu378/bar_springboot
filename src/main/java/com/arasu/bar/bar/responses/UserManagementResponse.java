package com.arasu.bar.bar.responses;

import com.arasu.bar.bar.application.entities.UserLiquor;
import com.arasu.bar.bar.application.entities.UserManagement;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserManagementResponse {
    @JsonProperty("IsSuccess")
    private boolean isSuccess;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("UserManagement")
    private UserManagement userManagement;
    public UserManagementResponse() {}

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean success) {
        isSuccess = success;
    }

}
