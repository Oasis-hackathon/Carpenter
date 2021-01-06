package org.carpenter.domain.goal.dto;

import lombok.Data;
import org.carpenter.domain.goal.Category;
import org.carpenter.domain.goal.GoalRoot;
import org.carpenter.domain.user.Carpenter;

import java.time.LocalDate;

@Data
public class PostRootDto {
    private String title;
    private String description;
    private Boolean published;
    private LocalDate startDate;
    private LocalDate endDate;
    private Category category;
    private Carpenter carpenter;

    public GoalRoot toEntity() {
        return GoalRoot.builder().title(title).description(description).published(published).startDate(startDate).endDate(endDate).category(category).carpenter(carpenter).build();
    }
}
