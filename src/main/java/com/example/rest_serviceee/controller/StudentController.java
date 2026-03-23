package com.example.rest_serviceee.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private List<Student> studentList = new ArrayList<>();

    @PostMapping("/students")
    public String addStudents(@RequestBody List<Student> newStudents) {

        studentList.addAll(newStudents);

        return studentList.stream()
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .collect(Collectors.joining(", "));
    }

    @GetMapping("/students")
    public ResponseEntity<String> getStudents(
            @RequestHeader("Accept") String acceptHeader) {

        if (!acceptHeader.equals("text/plain")) {
            return ResponseEntity
                    .badRequest()
                    .body("Format non supporté");
        }

        String result = studentList.stream()
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .collect(Collectors.joining(", "));

        return ResponseEntity.ok(result);
    }



}
