package com.gustavo.br.crud_rockeseat_desafio01.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.br.crud_rockeseat_desafio01.course.entity.CourseEntity;
import com.gustavo.br.crud_rockeseat_desafio01.course.repository.CourseRepository;

@Service
public class CreateCourseService {
    
    @Autowired
    private CourseRepository repository;

    public CourseEntity execute(CourseEntity courseEntity) throws Exception {
        var courseFound = this.repository.findByName(courseEntity.getName()).isEmpty();

        if(courseFound == false) {
            throw new Exception("Esse curso já existe");
        }

        return this.repository.save(courseEntity);
    };

}
