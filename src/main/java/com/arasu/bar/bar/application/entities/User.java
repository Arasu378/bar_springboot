package com.arasu.bar.bar.application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "userprofile")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonProperty("Id")
	private Long id;

//    @Column(name = "UserProfileId")
//    @JsonProperty("UserProfileId")
//	public int userProfileId;
    @NotNull
    @Column(name = "UserFirstName")
    @JsonProperty("UserFirstName")
	public String userFirstName;
    @NotNull
    @Column(name = "UserLastName")
    @JsonProperty("UserLastName")
	public String userLastName;
    @NotNull
    @Column(name = "UserMobileNumber")
    @JsonProperty("UserMobileNumber")
	public String userMobileNumber;
    @NotNull
    @Column(name = "UserEmail")
    @JsonProperty("UserEmail")
	public String userEmail;
    @NotNull
    @Column(name = "UserVenueName")
    @JsonProperty("UserVenueName")
	public String userVenueName;
    @NotNull
    @Column(name = "UserCountry")
    @JsonProperty("UserCountry")
	public String userCountry;

    @Column(name = "UserOftenInventory")
    @JsonProperty("UserOftenInventory")
	public String userOftenInventory;

    @Column(name = "UserInventoryTime")
    @JsonProperty("UserInventoryTime")
	public Integer userInventoryTime;

    @Column(name = "UserLastLogin")
    @JsonProperty("UserLastLogin")
	public String userLastLogin;

    @Column(name = "IsActive")
    @JsonProperty("IsActive")
	public boolean isActive;

    @Column(name = "CreatedOn")
    @JsonProperty("CreatedOn")
	public String createdOn;

    @Column(name = "ModifiedOn")
    @JsonProperty("ModifiedOn")
	public String modifiedOn;

    @Column(name = "Password")
    @JsonProperty("Password")
	public String password;

    @Column(name = "UserRole")
    @JsonProperty("UserRole")
	public String userRole;

    @Column(name = "ParentUserProfileId")
    @JsonProperty("ParentUserProfileId")
    public Long parentUserProfileId;

    @Column(name = "UserAuthorizationKey")
    @JsonProperty("UserAuthorizationKey")
    public String userAuthorizationKey;
	public User(){
		
	}

    public User(@NotNull String userFirstName, @NotNull String userLastName, @NotNull String userMobileNumber, @NotNull String userEmail, @NotNull String userVenueName, @NotNull String userCountry, String userOftenInventory, Integer userInventoryTime, String password, String userRole, String createdOn) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userMobileNumber = userMobileNumber;
        this.userEmail = userEmail;
        this.userVenueName = userVenueName;
        this.userCountry = userCountry;
        this.userOftenInventory = userOftenInventory;
        this.userInventoryTime = userInventoryTime;
        this.password = password;
        this.userRole = userRole;
        this.createdOn = createdOn;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserVenueName() {
        return userVenueName;
    }

    public void setUserVenueName(String userVenueName) {
        this.userVenueName = userVenueName;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserOftenInventory() {
        return userOftenInventory;
    }

    public void setUserOftenInventory(String userOftenInventory) {
        this.userOftenInventory = userOftenInventory;
    }

    public Integer getUserInventoryTime() {
        return userInventoryTime;
    }

    public void setUserInventoryTime(Integer userInventoryTime) {
        this.userInventoryTime = userInventoryTime;
    }

    public String getUserLastLogin() {
        return userLastLogin;
    }

    public void setUserLastLogin(String userLastLogin) {
        this.userLastLogin = userLastLogin;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getUserAuthorizationKey() {
        return userAuthorizationKey;
    }

    public void setUserAuthorizationKey(String userAuthorizationKey) {
        this.userAuthorizationKey = userAuthorizationKey;
    }
}
