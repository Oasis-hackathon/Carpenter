package org.carpenter.domain.goal.dto;

import lombok.Data;

@Data
public class UpdateNodeDto {
    private Long id;
    private String title;
    private Integer order;
    private Integer achievementRate;
}
