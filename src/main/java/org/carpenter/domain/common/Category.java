package org.carpenter.domain.common;

import lombok.Getter;
import org.carpenter.domain.goal.GoalRoot;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Entity
public class Category {

    @Id
    private Long id;
    private String title;
    private Boolean published;

    @OneToMany(mappedBy = "category")
    private Set<GoalRoot> rootSet;
}