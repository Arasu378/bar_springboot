package com.arasu.bar.bar.application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
@Table(name = "usermanagement_bar")
public class UserManagementBar  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonProperty("Id")
    private Long id;

    @Column(name = "UserManagementId")
    @JsonProperty("UserManagementId")
    private Long userManagementId;

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

    @Column(name = "UserProfileId")
    @JsonProperty("UserProfileId")
    private Long userProfileId;

    @Column(name = "BarId")
    @JsonProperty("BarId")
    private Long barId;

    @Column(name = "ParentUserProfileId")
    @JsonProperty("ParentUserProfileId")
    private Long parentUserProfileId;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "UserProfileId", nullable = false)
//    private UserManagement barList;

    public UserManagementBar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserManagementId() {
        return userManagementId;
    }

    public void setUserManagementId(Long userManagementId) {
        this.userManagementId = userManagementId;
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

    public Long getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
    }

    public Long getBarId() {
        return barId;
    }

    public void setBarId(Long barId) {
        this.barId = barId;
    }

    public Long getParentUserProfileId() {
        return parentUserProfileId;
    }

    public void setParentUserProfileId(Long parentUserProfileId) {
        this.parentUserProfileId = parentUserProfileId;
    }
}
