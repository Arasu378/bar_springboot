package com.arasu.bar.bar.application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "liquor_category")
public class LiquorCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    @Column(name = "Id")
    private Long Id;

    @JsonProperty("LiquorName")
    @Column(name = "LiquorName")
    private String liquorName;


    @Lob
    @Column(name = "Data")
    @JsonProperty("Data")
    private byte[] data;

    @JsonProperty("CreatedOn")
    @Column(name = "CreatedOn")
    private String createdOn;

    @JsonProperty("ModifiedOn")
    @Column(name = "ModifiedOn")
    private String modifiedOn;

    public LiquorCategory() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLiquorName() {
        return liquorName;
    }

    public void setLiquorName(String liquorName) {
        this.liquorName = liquorName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
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
