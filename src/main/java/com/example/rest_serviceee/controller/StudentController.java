package com.example.rest_serviceee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/students")

public class StudentController {


    private List<Student> students = new ArrayList<>();

    @PostMapping
    public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> newStudents) {
        try {
            students.addAll(newStudents);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(students);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getStudents(@RequestHeader(value = "Accept", required = false) String acceptHeader) {

        try {
            if (acceptHeader == null) {
                return ResponseEntity
                        .badRequest()
                        .body("Header Accept requis");
            }

            if (!acceptHeader.equals("application/json") && !acceptHeader.equals("text/plain")) {
                return ResponseEntity
                        .status(HttpStatus.NOT_IMPLEMENTED)
                        .body("Format non supporté");
            }

            return ResponseEntity
                    .ok(students);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }

    }
}
