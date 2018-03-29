package com.arasu.bar.bar.application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "bartable")
public class Bar implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonProperty("Id")
    private Long id;

    @Column(name = "UserProfileId")
    @JsonProperty("UserProfileId")
    private Long userProfileId;

    @NotNull
    @NotBlank
    @Column(name = "BarName")
    @JsonProperty("BarName")
    private String barName;

    @Column(name = "CreatedOn")
    @JsonProperty("CreatedOn")
    private String createdOn;

    @Column(name = "ModifiedOn")
    @JsonProperty("ModifiedOn")
    private String modifiedOn;

    public Bar() {
    }

    public Bar(@NotNull Long userProfileId, @NotNull String barName, String createdOn, String modifiedOn) {
        this.userProfileId = userProfileId;
        this.barName = barName;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public Bar(@NotNull Long userProfileId, @NotNull String barName, String modifiedOn) {
        this.userProfileId = userProfileId;
        this.barName = barName;
        this.modifiedOn = modifiedOn;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
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
