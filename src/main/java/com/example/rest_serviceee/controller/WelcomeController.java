package com.example.rest_serviceee.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam(required = false) String name) {

        if (name == null || name.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body("Le paramètre 'name' est requis");
        }

        return ResponseEntity
                .ok("Bienvenue " + name);
    }
}
