package com.arasu.bar.bar.application.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "controller.service", ignoreUnknownFields = false)
@Component
public class ServiceProperties {
    @NotNull
    private String name = "Empty";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
