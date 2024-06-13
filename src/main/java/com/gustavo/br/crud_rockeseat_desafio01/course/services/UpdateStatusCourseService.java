package com.gustavo.br.crud_rockeseat_desafio01.course.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.br.crud_rockeseat_desafio01.course.dto.RequestUpdateActiveCourseDTO;
import com.gustavo.br.crud_rockeseat_desafio01.course.entity.CourseEntity;
import com.gustavo.br.crud_rockeseat_desafio01.course.enums.ActiveCourseENUM;
import com.gustavo.br.crud_rockeseat_desafio01.course.repository.CourseRepository;


@Service
public class UpdateStatusCourseService {
    
    @Autowired
    private CourseRepository repository;

    private void updateStatusActiveCourse(RequestUpdateActiveCourseDTO courseDTO, CourseEntity entity){
        switch (courseDTO.getIsActive()) {
            case "active":
                    entity.setActive(ActiveCourseENUM.ACTIVE.toString());
                break;
            case "disabled":
                    entity.setActive(ActiveCourseENUM.DISABLED.toString());
                break;
            default:
                break;
        }
    }

    public CourseEntity execute(UUID id, RequestUpdateActiveCourseDTO activeCourseDTO) throws Exception {
        var foundCourse = this.repository.findById(id);

        if(foundCourse.isEmpty()) {
            throw new Exception("Esse curso não existe");
        }

        CourseEntity entity = foundCourse.get();

        this.updateStatusActiveCourse(activeCourseDTO, entity);

        return this.repository.save(entity);
    }
}
