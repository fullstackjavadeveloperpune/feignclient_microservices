package com.fullstack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/employeefallback")
    public ResponseEntity<String> employeeFallBack(){
        return ResponseEntity.ok("Employee Service is down please wait!!!!!!!");
    }
    @GetMapping("/departmentfallback")
    public ResponseEntity<String> departmentFallBack(){
        return ResponseEntity.ok("Department Service is down please wait!!!!!!!");
    }

}
