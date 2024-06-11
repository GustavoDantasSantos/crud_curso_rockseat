package com.gustavo.br.crud_rockeseat_desafio01.course.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.br.crud_rockeseat_desafio01.course.services.DeleteCourseService;

@RestController
@RequestMapping("/course")
public class DeleteCourseController {
    
    @Autowired
    private DeleteCourseService service;

    @DeleteMapping("/{courseid}")
    public ResponseEntity<String> delete (@PathVariable("courseid") UUID id) {
        try {
            String courseDeleted = this.service.execute(id);
            return ResponseEntity.ok().body(courseDeleted);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
