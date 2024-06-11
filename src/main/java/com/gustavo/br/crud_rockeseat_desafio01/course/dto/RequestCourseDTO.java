package com.gustavo.br.crud_rockeseat_desafio01.course.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class RequestCourseDTO {
    @Schema(example = "Curso Java", requiredMode = RequiredMode.REQUIRED)
    private String name;

    @Schema(example = "T.I", requiredMode = RequiredMode.REQUIRED)
    private String category;
}
