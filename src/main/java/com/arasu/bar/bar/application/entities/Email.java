package com.arasu.bar.bar.application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "email_management")
public class Email implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonProperty("Id")
    private Long id;

    @NotBlank
    @NotNull
    @Column(name = "UserEmail", nullable = false)
    @JsonProperty("UserEmail")
    private String userEmail;

    @Column(name = "UserProfileId")
    @JsonProperty("UserProfileId")
    private Long userProfileId;


    @Column(name = "CreatedOn")
    @JsonProperty("CreatedOn")
    private String createdOn;


    @Column(name = "ModifiedOn")
    @JsonProperty("ModifiedOn")
    private String modifiedOn;

    public Email() {
    }

    public Email(@NotBlank @NotNull String userEmail, Long userProfileId, String createdOn) {
        this.userEmail = userEmail;
        this.userProfileId = userProfileId;
        this.createdOn = createdOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
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
