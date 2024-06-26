package com.gustavo.br.crud_rockeseat_desafio01.course.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.br.crud_rockeseat_desafio01.course.dto.RequestCourseDTO;
import com.gustavo.br.crud_rockeseat_desafio01.course.entity.CourseEntity;
import com.gustavo.br.crud_rockeseat_desafio01.course.services.UpdateNameOrCategoryCourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/course")
public class UpdateNameOrCategoryCourseController {
    
    @Autowired
    private UpdateNameOrCategoryCourseService service;

    @PutMapping("/{courseid}")
    @Tag(name = "Cursos", description = "Esses endpoint serve para criação de crud")
    @Operation(
        summary = "Atualizando nome e categoria de um curso", 
        description = "esse endpoint serve para atualizar nome e categoria de um curso"
    )
    public ResponseEntity<Object> update(@PathVariable("courseid") UUID id, @RequestBody RequestCourseDTO courseDTO) {
        try {
            CourseEntity updateCourse = this.service.execute(id, courseDTO);
            return ResponseEntity.ok().body(updateCourse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
