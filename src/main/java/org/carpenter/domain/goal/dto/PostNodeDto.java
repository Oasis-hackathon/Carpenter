package org.carpenter.domain.goal.dto;

import lombok.Data;
import org.carpenter.domain.goal.GoalNode;
import org.carpenter.domain.goal.GoalRoot;

@Data
public class PostNodeDto {

    private String title;
    private Integer order;
    private Integer achievementRate;
    private GoalRoot root;

    public GoalNode toEntity() {
        return GoalNode.builder().title(title).order(order).achievementRate(achievementRate).root(root).build();
    }
}
