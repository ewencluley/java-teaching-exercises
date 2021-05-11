package com.ewencluley.javatasks.springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ewencluley.javatasks.springboot.model.Status;

@RestController
public class StatusController {
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public Status status() {
        return new Status("OK");
    }
}
