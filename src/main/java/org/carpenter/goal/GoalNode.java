package org.carpenter.goal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
