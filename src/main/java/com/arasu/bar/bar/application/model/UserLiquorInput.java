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
public class UserLiquorInput {
    @JsonProperty("UserProfileId")
    public Long userProfileId;

    @JsonProperty("BarId")
    public Long barId;

    @JsonProperty("SectionId")
    public Long sectionId;

    @NotBlank
    @NotNull
    @JsonProperty("LiquorName")
    public String liquorName;

    @NotBlank
    @NotNull
    @JsonProperty("LiquorCapacity")
    public String liquorCapacity;

    @JsonProperty("Shots")
    public Integer shots;

    @NotBlank
    @NotNull
    @JsonProperty("Category")
    public String category;

    @JsonProperty("SubCategory")
    public String subCategory;

    @JsonProperty("ParLevel")
    public Integer parLevel;

    @JsonProperty("DistributorName")
    public String distributorName;

    @JsonProperty("PriceUnit")
    public Integer priceUnit;

    @JsonProperty("BinNumber")
    public String binNumber;

    @JsonProperty("ProductCode")
    public String productCode;

    @JsonProperty("Type")
    public String type;

    @JsonProperty("FullWeight")
    public String fullWeight;

    @JsonProperty("EmptyWeight")
    public String emptyWeight;

    @JsonProperty("TotalBottles")
    public Integer totalBottles;

    // Picture id is commented to get id from picture url from service class
    @JsonProperty("PictureId")
    public Long pictureId;

    @JsonProperty("MinValue")
    public Double minValue;

    @JsonProperty("MaxValue")
    public Double maxValue;


    @JsonProperty("PictureURL")
    public String pictureURL;


    public UserLiquorInput(){}
}
