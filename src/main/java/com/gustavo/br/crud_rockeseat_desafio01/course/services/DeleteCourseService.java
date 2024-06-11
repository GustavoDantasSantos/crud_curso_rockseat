package com.gustavo.br.crud_rockeseat_desafio01.course.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.br.crud_rockeseat_desafio01.course.repository.CourseRepository;

@Service
public class DeleteCourseService {
    
    @Autowired
    private CourseRepository repository;

    public String execute(UUID id) throws Exception {
        var courseFound = this.repository.findById(id);

        if(courseFound.isEmpty()) {
            throw new Exception("Esse curso não existente");
        }

        this.repository.delete(courseFound.get());
        return "Curso Deletado com Sucesso";
    };
}
