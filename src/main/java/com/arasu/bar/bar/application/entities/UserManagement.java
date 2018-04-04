package com.arasu.bar.bar.application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usermanagement")
public class UserManagement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonProperty("Id")
    private Long id;

    @Column(name = "UserProfileId")
    @JsonProperty("UserProfileId")
    private Long userProfileId;

    @Column(name = "UserName")
    @JsonProperty("UserName")
    private String userName;

    @NotBlank
    @NotNull
    @Email
    @Column(name = "UserEmail")
    @JsonProperty("UserEmail")
    private String userEmail;

    @Column(name = "CreatedOn")
    @JsonProperty("CreatedOn")
    private String createdOn;

    @Column(name = "ModifiedOn")
    @JsonProperty("ModifiedOn")
    private String modifiedOn;

    @Column(name = "UserRole")
    @JsonProperty("UserRole")
    private String userRole;

    @Column(name = "ParentUserProfileId")
    @JsonProperty("ParentUserProfileId")
    private Long parentUserProfileId;

    @NotBlank
    @NotNull
    @Column(name = "UserFirstName")
    @JsonProperty("UserFirstName")
    private String userFirstName;

    @Column(name = "UserLastName")
    @JsonProperty("UserLastName")
    private String userLastName;

//    @OneToMany(cascade = CascadeType.ALL,
//    fetch = FetchType.LAZY,
//    mappedBy = "barList")
//    private Set<UserManagementBar> barList = new HashSet<>();
//
//

    public UserManagement() {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Long getParentUserProfileId() {
        return parentUserProfileId;
    }

    public void setParentUserProfileId(Long parentUserProfileId) {
        this.parentUserProfileId = parentUserProfileId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

//    public Set<UserManagementBar> getBarList() {
//        return barList;
//    }
//
//    public void setBarList(Set<UserManagementBar> barList) {
//        this.barList = barList;
//    }
}
