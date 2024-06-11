package com.gustavo.br.crud_rockeseat_desafio01.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.br.crud_rockeseat_desafio01.course.dto.RequestCourseDTO;
import com.gustavo.br.crud_rockeseat_desafio01.course.entity.CourseEntity;
import com.gustavo.br.crud_rockeseat_desafio01.course.repository.CourseRepository;

@Service
public class CreateCourseService {
    
    @Autowired
    private CourseRepository repository;

    public CourseEntity execute(RequestCourseDTO courseDTO) throws Exception {
        var courseFound = this.repository.findByName(courseDTO.getName()).isEmpty();

        if(courseFound == false) {
            throw new Exception("Esse curso já existe");
        }

        CourseEntity courseEntity = new CourseEntity(courseDTO);
        return this.repository.save(courseEntity);
    };

}
