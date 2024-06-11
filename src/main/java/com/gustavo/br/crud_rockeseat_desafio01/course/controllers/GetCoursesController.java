package com.gustavo.br.crud_rockeseat_desafio01.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.br.crud_rockeseat_desafio01.course.entity.CourseEntity;
import com.gustavo.br.crud_rockeseat_desafio01.course.services.GetCoursesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/course")
public class GetCoursesController {
    
    @Autowired
    private GetCoursesService service;

    @GetMapping("/")
    @Tag(name = "Cursos", description = "Esses endpoint serve para criação de crud")
    @Operation(
        summary = "Listando cursos", 
        description = "esse endpoint serve para listar todos os curso"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = CourseEntity.class))
        }),
        @ApiResponse(responseCode = "400", description = "[]")
    })
    public ResponseEntity<Object> getCourses() {
        try {
            var courses = this.service.execute();
            return ResponseEntity.ok().body(courses);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
