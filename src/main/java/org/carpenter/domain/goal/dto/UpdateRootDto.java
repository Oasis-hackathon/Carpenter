package org.carpenter.domain.goal.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateRootDto {
    private Long id;
    private String title;
    private String description;
    private Boolean published;
    private LocalDate startDate;
    private LocalDate endDate;
}
