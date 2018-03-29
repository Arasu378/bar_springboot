package com.arasu.bar.bar.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class Register {
    @JsonProperty("UserFirstName")
    public String userFirstName;

    @JsonProperty("UserLastName")
    public String userLastName;

    @JsonProperty("UserMobileNumber")
    public String userMobileNumber;

    @JsonProperty("UserEmail")
    public String userEmail;

    @JsonProperty("UserVenueName")
    public String userVenueName;

    @JsonProperty("UserCountry")
    public String userCountry;

    @JsonProperty("UserOftenInventory")
    public String userOftenInventory;

    @JsonProperty("UserInventoryTime")
    public Integer userInventoryTime;

    @JsonProperty("UserRole")
    public String userRole;

    @JsonProperty("ParentUserProfileId")
    public Long parentUserProfileId;
    public Register() {}
}
