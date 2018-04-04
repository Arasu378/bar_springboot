package com.arasu.bar.bar.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class ErrorDetails {
    @JsonProperty("TimeStamp")
    private Date timeStamp;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Details")
    private String details;

    public ErrorDetails(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

}
