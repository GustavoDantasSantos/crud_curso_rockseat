package com.gustavo.br.crud_rockeseat_desafio01.course.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.br.crud_rockeseat_desafio01.course.dto.RequestUpdateActiveCourseDTO;
import com.gustavo.br.crud_rockeseat_desafio01.course.services.UpdateStatusCourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/course")
public class UpdateStatusCourseController {

    @Autowired
    private UpdateStatusCourseService service;
    

    @PatchMapping("/{courseid}")
    @Tag(name = "Cursos", description = "Esses endpoint serve para criação de crud")
    @Operation(
        summary = "Atualizando a propriedade active (ativo) de um curso", 
        description = "esse endpoint serve para atualizar propriedade active (ativo) de um curso"
    )
    public ResponseEntity<Object> updateStatus(@PathVariable("courseid") UUID id, @RequestBody RequestUpdateActiveCourseDTO courseDTO) {
        try {
            var updatedCourse= this.service.execute(id, courseDTO);
            return ResponseEntity.ok().body(updatedCourse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
