package com.rakuten.hotelservices.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @GetMapping
    ResponseEntity getAllStaff() {
        List staff =  Arrays.asList("A","B","C","D");
        return ResponseEntity.ok(staff);
    }
}
