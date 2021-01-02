package org.carpenter.common;

import org.carpenter.goal.GoalRoot;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Category {

    @Id
    private Long id;
    private String title;
    private Boolean published;

    @OneToMany(mappedBy = "category")
    private Set<GoalRoot> rootSet;
}
