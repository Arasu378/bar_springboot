package com.arasu.bar.bar.application.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "liquor_list")
public class Liquor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Integer _id;
    @JsonProperty("LocalId")
    private int local_id;
    @JsonProperty("BaseUri")
    private String base_uri;
    @JsonProperty("ParId")
    private int par_id;
    @JsonProperty("ParentParId")
    private String parent_par_id;
    @JsonProperty("ParOrder")
    private String par_order;
    @JsonProperty("ModCount")
    private String mod_count;
    @JsonProperty("LastUpdatedServer")
    private String last_updated_server;
    @JsonProperty("LocalDelete")
    private String local_delete;
    @JsonProperty("AlcoholSubType")
    private String alcohol_subtype;
    @JsonProperty("AlcoholType")
    private String alcohol_type;
    @JsonProperty("AsciiName")
    private String ascii_name;
    @JsonProperty("BinNumber")
    private String bin_number;
    @JsonProperty("CapacityML")
    private int capacity_mL;
    @JsonProperty("ContainerType")
    private String container_type;
    @JsonProperty("CreatedAt")
    private String created_at;
    @JsonProperty("DeletedAt")
    private String deleted_at;
    @JsonProperty("Establishment")
    private String establishment;
    @JsonProperty("Image")
    private String image;
    @JsonProperty("LiquidColor")
    private String liquid_color;
    @JsonProperty("MaxHeight")
    private double max_height;
    @JsonProperty("Measurable")
    private int measurable;
    @JsonProperty("MediumPictureUrl")
    private String medium_picture_url;
    @JsonProperty("MinHeight")
    private double min_height;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("PictureUrl")
    private String picture_url;
    @JsonProperty("ProductCode")
    private String product_code;
    @JsonProperty("ProductType")
    private String product_type;
    @JsonProperty("SmallPictureUrl")
    private String small_picture_url;
    @JsonProperty("ThumbnailUrl")
    private String thumbnail_url;
    @JsonProperty("Transparent")
    private boolean transparent;

    public Liquor() {
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public int getLocal_id() {
        return local_id;
    }

    public void setLocal_id(int local_id) {
        this.local_id = local_id;
    }

    public String getBase_uri() {
        return base_uri;
    }

    public void setBase_uri(String base_uri) {
        this.base_uri = base_uri;
    }

    public int getPar_id() {
        return par_id;
    }

    public void setPar_id(int par_id) {
        this.par_id = par_id;
    }

    public String getParent_par_id() {
        return parent_par_id;
    }

    public void setParent_par_id(String parent_par_id) {
        this.parent_par_id = parent_par_id;
    }

    public String getPar_order() {
        return par_order;
    }

    public void setPar_order(String par_order) {
        this.par_order = par_order;
    }

    public String getMod_count() {
        return mod_count;
    }

    public void setMod_count(String mod_count) {
        this.mod_count = mod_count;
    }

    public String getLast_updated_server() {
        return last_updated_server;
    }

    public void setLast_updated_server(String last_updated_server) {
        this.last_updated_server = last_updated_server;
    }

    public String getLocal_delete() {
        return local_delete;
    }

    public void setLocal_delete(String local_delete) {
        this.local_delete = local_delete;
    }

    public String getAlcohol_subtype() {
        return alcohol_subtype;
    }

    public void setAlcohol_subtype(String alcohol_subtype) {
        this.alcohol_subtype = alcohol_subtype;
    }

    public String getAlcohol_type() {
        return alcohol_type;
    }

    public void setAlcohol_type(String alcohol_type) {
        this.alcohol_type = alcohol_type;
    }

    public String getAscii_name() {
        return ascii_name;
    }

    public void setAscii_name(String ascii_name) {
        this.ascii_name = ascii_name;
    }

    public String getBin_number() {
        return bin_number;
    }

    public void setBin_number(String bin_number) {
        this.bin_number = bin_number;
    }

    public int getCapacity_mL() {
        return capacity_mL;
    }

    public void setCapacity_mL(int capacity_mL) {
        this.capacity_mL = capacity_mL;
    }

    public String getContainer_type() {
        return container_type;
    }

    public void setContainer_type(String container_type) {
        this.container_type = container_type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLiquid_color() {
        return liquid_color;
    }

    public void setLiquid_color(String liquid_color) {
        this.liquid_color = liquid_color;
    }

    public double getMax_height() {
        return max_height;
    }

    public void setMax_height(double max_height) {
        this.max_height = max_height;
    }

    public int getMeasurable() {
        return measurable;
    }

    public void setMeasurable(int measurable) {
        this.measurable = measurable;
    }

    public String getMedium_picture_url() {
        return medium_picture_url;
    }

    public void setMedium_picture_url(String medium_picture_url) {
        this.medium_picture_url = medium_picture_url;
    }

    public double getMin_height() {
        return min_height;
    }

    public void setMin_height(double min_height) {
        this.min_height = min_height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getSmall_picture_url() {
        return small_picture_url;
    }

    public void setSmall_picture_url(String small_picture_url) {
        this.small_picture_url = small_picture_url;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public boolean isTransparent() {
        return transparent;
    }

    public void setTransparent(boolean transparent) {
        this.transparent = transparent;
    }
}
