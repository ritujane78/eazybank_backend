package com.jane.springsection.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping("/myContact")
    public String getContactDetails() {
        return "My Contact Details from DB";
    }
}
