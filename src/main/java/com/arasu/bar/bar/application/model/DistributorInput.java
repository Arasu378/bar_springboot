package com.arasu.bar.bar.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



@Getter
@Setter
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class DistributorInput {


    @JsonProperty("UserProfileId")
    private Long userProfileId;

    @NotNull
    @NotBlank
    @JsonProperty("DistributorName")
    private String distributorName;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Mobile")
    private String mobile;

    @JsonProperty("Address")
    private String address;

    public DistributorInput() {
    }
}
