package org.carpenter.domain.goal;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.carpenter.domain.goal.dto.UpdateNodeDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class GoalNode {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Integer order;
    private Integer achievementRate;

    @ManyToOne
    private GoalRoot goalRoot;

    @Builder
    public GoalNode(String title, Integer order, Integer achievementRate, GoalRoot root) {
        this.title = title;
        this.order = order;
        this.achievementRate = achievementRate;
        this.goalRoot = root;
    }

    public void update(UpdateNodeDto dto) {
        this.title = dto.getTitle();
        this.order = dto.getOrder();
        this.achievementRate = dto.getAchievementRate();
    }
}
