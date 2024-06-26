package com.gustavo.br.crud_rockeseat_desafio01.course.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.gustavo.br.crud_rockeseat_desafio01.course.dto.RequestCourseDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "course")
@Data
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String category;
    private String active;
    
    @CreationTimestamp
    private LocalDateTime created_at;
    
    @UpdateTimestamp
    private LocalDateTime updated_at;

    public CourseEntity(RequestCourseDTO courseDTO) {
        this.name = courseDTO.getName();
        this.category = courseDTO.getCategory();
        this.active = "active";
    }

    public CourseEntity() {}
}
