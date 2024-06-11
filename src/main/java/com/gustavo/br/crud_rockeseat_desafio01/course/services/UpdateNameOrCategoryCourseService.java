package com.gustavo.br.crud_rockeseat_desafio01.course.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.br.crud_rockeseat_desafio01.course.dto.RequestCourseDTO;
import com.gustavo.br.crud_rockeseat_desafio01.course.entity.CourseEntity;
import com.gustavo.br.crud_rockeseat_desafio01.course.repository.CourseRepository;

@Service
public class UpdateNameOrCategoryCourseService {
    
    @Autowired
    private CourseRepository repository;

    public CourseEntity execute(UUID id, RequestCourseDTO courseDTO) throws Exception{
        var foundCourse = this.repository.findById(id);
        
        if (foundCourse.isEmpty()) {
            throw new Exception("Esse curso não existe");
        }

        CourseEntity updateCourse = foundCourse.get();
        
        if(courseDTO.getCategory() == null) {
            updateCourse.setName(courseDTO.getName());
        } else if (courseDTO.getName() == null) {
            updateCourse.setCategory(courseDTO.getCategory());
        } else {
            updateCourse.setName(courseDTO.getName());
            updateCourse.setCategory(courseDTO.getCategory());
        }

        return this. repository.save(updateCourse);
    };
}
