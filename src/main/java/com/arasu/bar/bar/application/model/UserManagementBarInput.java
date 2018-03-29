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
public class UserManagementBarInput {
    @JsonProperty("UserProfileId")
    public Long userProfileId;

    @JsonProperty("UserManagementId")
    public Long userManagementId;

    @JsonProperty("BarId")
    public Long barId;

    @JsonProperty("ParentUserProfileId")
    public Long parentUserProfileId;


    @JsonProperty("BarName")
    public String barName;


    public UserManagementBarInput(){}
}
