package com.gustavo.br.crud_rockeseat_desafio01.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gustavo.br.crud_rockeseat_desafio01.course.services.GetCoursesService;

@Controller
@RequestMapping("/course")
public class GetCoursesController {
    
    @Autowired
    private GetCoursesService service;

    @GetMapping("/")
    public ResponseEntity<Object> getCourses() {
        try {
            var courses = this.service.execute();
            return ResponseEntity.ok().body(courses);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
