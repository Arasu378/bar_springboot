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
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class UserManagementInput {
    @JsonProperty("UserProfileId")
    public Long userProfileId;


    @NotBlank
    @NotNull
    @JsonProperty("UserEmail")
    public String userEmail;


    @NotBlank
    @NotNull
    @JsonProperty("UserRole")
    public String userRole;

    @JsonProperty("ParentUserProfileId")
    public Long parentUserProfileId;

    @NotBlank
    @NotNull
    @JsonProperty("UserFirstName")
    public String userFirstName;

    @NotBlank
    @NotNull
    @JsonProperty("UserLastName")
    public String userLastName;

    @JsonProperty("UserCountry")
    public String userCountry;

    @JsonProperty("UserVenueName")
    public String userVenueName;

    @JsonProperty("UserManagementBar")
    public List<UserManagementBarInput> userManagementBar;


    public UserManagementInput(){}
}
