package com.arasu.bar.bar.application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "distributor")
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonProperty("Id")
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "DistributorName")
    @JsonProperty("DistributorName")
    private String distributorName;

    @Column(name = "UserProfileId")
    @JsonProperty("UserProfileId")
    private Long userProfileId;

    @Column(name = "Email")
    @JsonProperty("Email")
    private String email;

    @Column(name = "Mobile")
    @JsonProperty("Mobile")
    private String mobile;

    @Column(name = "Address")
    @JsonProperty("Address")
    private String address;

    @Column(name = "CreatedOn")
    @JsonProperty("CreatedOn")
    private String createdOn;

    @Column(name = "ModifiedOn")
    @JsonProperty("ModifiedOn")
    private String modifiedOn;

    public Distributor() {
    }

    public Distributor(String distributorName, Long userProfileId, String email, String mobile, String address, String createdOn) {
        this.distributorName = distributorName;
        this.userProfileId = userProfileId;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.createdOn = createdOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public Long getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
