package com.arasu.bar.bar.responses;

import com.arasu.bar.bar.application.entities.Section;
import com.arasu.bar.bar.application.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class SectionResponse {
    @JsonProperty("IsSuccess")
    private boolean isSuccess;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Section")
    private Section section;
    public SectionResponse() {}

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean success) {
        isSuccess = success;
    }
}
