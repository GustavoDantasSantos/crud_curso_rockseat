package com.gustavo.br.crud_rockeseat_desafio01.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.br.crud_rockeseat_desafio01.course.entity.CourseEntity;
import com.gustavo.br.crud_rockeseat_desafio01.course.repository.CourseRepository;

@Service
public class UpdateNameOrCategoryCourseService {
    
    @Autowired
    private CourseRepository repository;

    public void execute(CourseEntity courseEntity) throws Exception{
        var foundCourse = this.repository.findByNameOrCategory(courseEntity.getName(), courseEntity.getCategory());
        if (foundCourse == null) {
            throw new Exception("Esse curso não existe");
        }
        System.out.println(foundCourse);
    };

}
