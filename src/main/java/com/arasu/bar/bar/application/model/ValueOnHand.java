package com.arasu.bar.bar.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class ValueOnHand {

        @JsonProperty("Id")
        private Long id;
        @JsonProperty("LiquorName")
        private String liquorName;
        @JsonProperty("LiquorCapacity")
        private String liquorCapacity;
        @JsonProperty("ParLevel")
        private Integer parLevel;
        @JsonProperty("DistributorId")
        private Long distributorId;
        @JsonProperty("UnitPrice")
        private String unitPrice;
        @JsonProperty("TotalBottles")
        private String totalBottles;
        @JsonProperty("TotalValues")
        private String totalValues;

    public ValueOnHand() {
    }
}
