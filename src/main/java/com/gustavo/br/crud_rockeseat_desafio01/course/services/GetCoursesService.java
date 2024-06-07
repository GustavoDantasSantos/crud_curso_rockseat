package com.gustavo.br.crud_rockeseat_desafio01.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.br.crud_rockeseat_desafio01.course.entity.CourseEntity;
import com.gustavo.br.crud_rockeseat_desafio01.course.repository.CourseRepository;

@Service
public class GetCoursesService {
    
    @Autowired
    private CourseRepository repository;

    public List<CourseEntity> execute() {
        return this.repository.findAll();
    }
}
