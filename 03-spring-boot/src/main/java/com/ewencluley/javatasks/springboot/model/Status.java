package com.ewencluley.javatasks.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status {
    @JsonProperty
    private String status;

    public Status(String status) {
        this.status = status;
    }
}
