package com.gustavo.br.crud_rockeseat_desafio01.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.br.crud_rockeseat_desafio01.course.dto.RequestCourseDTO;
import com.gustavo.br.crud_rockeseat_desafio01.course.services.CreateCourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/course")
public class CreateCourseController {
    
    @Autowired
    private CreateCourseService service;

    @PostMapping("/")
    @Tag(name = "Cursos", description = "Esses endpoint serve para criação de crud")
    @Operation(summary = "Criando um curso", description = "esse endpoint serve para criação de um curso")
    public ResponseEntity<Object> create(@RequestBody RequestCourseDTO courseDTO) {
        try {
            var courseSaved = this.service.execute(courseDTO);
            return ResponseEntity.ok().body(courseSaved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
