package com.gustavo.br.crud_rockeseat_desafio01.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gustavo.br.crud_rockeseat_desafio01.course.entity.CourseEntity;
import com.gustavo.br.crud_rockeseat_desafio01.course.services.UpdateNameOrCategoryCourseService;

@Controller
@RequestMapping("/course")
public class UpdateNameOrCategoryCourseController {
    
    @Autowired
    private UpdateNameOrCategoryCourseService service;

    @PutMapping("/")
    public void update(CourseEntity courseEntity) {
        try {
            this.service.execute(courseEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
