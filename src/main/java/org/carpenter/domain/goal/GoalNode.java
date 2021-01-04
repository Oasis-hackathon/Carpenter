package org.carpenter.domain.goal;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Entity
public class GoalNode {
    @Id
    private Long id;
    private String title;
    private Integer order;
    private Integer achievementRate;

    @ManyToOne
    private GoalRoot goalRoot;
}
