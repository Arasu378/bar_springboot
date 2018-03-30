package com.arasu.bar.bar.application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "user_liquor")
public class UserLiquor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonProperty("Id")
    private Long id;

    @Column(name = "UserProfileId")
    @JsonProperty("UserProfileId")
    private Long userProfileId;

    @Column(name = "BarId")
    @JsonProperty("BarId")
    private Long barId;

    @Column(name = "SectionId")
    @JsonProperty("SectionId")
    private Long sectionId;

    @NotNull
    @NotBlank
    @Column(name = "LiquorName")
    @JsonProperty("LiquorName")
    private String liquorName;

    @NotNull
    @NotBlank
    @Column(name = "LiquorCapacity")
    @JsonProperty("LiquorCapacity")
    private String liquorCapacity;

    @Column(name = "Shots")
    @JsonProperty("Shots")
    private Long shots;

    @NotNull
    @NotBlank
    @Column(name = "Category")
    @JsonProperty("Category")
    private String category;

    @Column(name = "SubCategory")
    @JsonProperty("SubCategory")
    private String subCategory;

    @Column(name = "ParLevel")
    @JsonProperty("ParLevel")
    private Long parLevel;

    @Column(name = "DistributorName")
    @JsonProperty("DistributorName")
    private String distributorName;

    @Column(name = "PriceUnit")
    @JsonProperty("PriceUnit")
    private String priceUnit;

    @Column(name = "BinNumber")
    @JsonProperty("BinNumber")
    private String binNumber;

    @Column(name = "ProductCode")
    @JsonProperty("ProductCode")
    private String productCode;

    @Column(name = "CreatedOn")
    @JsonProperty("CreatedOn")
    private String createdOn;

    @Column(name = "ModifiedOn")
    @JsonProperty("ModifiedOn")
    private String modifiedOn;

    @Column(name = "MinValue")
    @JsonProperty("MinValue")
    private Double minValue;

    @Column(name = "MaxValue")
    @JsonProperty("MaxValue")
    private Double maxValue;

    @Column(name = "PictureId")
    @JsonProperty("PictureId")
    private Long pictureId;

    @Column(name = "Type")
    @JsonProperty("Type")
    private String type;

    @Column(name = "FullWeight")
    @JsonProperty("FullWeight")
    private String fullWeight;

    @Column(name = "EmptyWeight")
    @JsonProperty("EmptyWeight")
    private String emptyWeight;

    @Column(name = "TotalBottles")
    @JsonProperty("TotalBottles")
    private Long totalBottles;

    public UserLiquor() {
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

    public Long getBarId() {
        return barId;
    }

    public void setBarId(Long barId) {
        this.barId = barId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getLiquorName() {
        return liquorName;
    }

    public void setLiquorName(String liquorName) {
        this.liquorName = liquorName;
    }

    public String getLiquorCapacity() {
        return liquorCapacity;
    }

    public void setLiquorCapacity(String liquorCapacity) {
        this.liquorCapacity = liquorCapacity;
    }

    public Long getShots() {
        return shots;
    }

    public void setShots(Long shots) {
        this.shots = shots;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public Long getParLevel() {
        return parLevel;
    }

    public void setParLevel(Long parLevel) {
        this.parLevel = parLevel;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getBinNumber() {
        return binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFullWeight() {
        return fullWeight;
    }

    public void setFullWeight(String fullWeight) {
        this.fullWeight = fullWeight;
    }

    public String getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(String emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public Long getTotalBottles() {
        return totalBottles;
    }

    public void setTotalBottles(Long totalBottles) {
        this.totalBottles = totalBottles;
    }
}
