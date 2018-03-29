package com.arasu.bar.bar.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestErrorInfo {
    public final String detail;
    public final String message;

    public RestErrorInfo(Exception ex, String detail) {
        this.detail = detail;
        this.message = ex.getLocalizedMessage();
    }
}
