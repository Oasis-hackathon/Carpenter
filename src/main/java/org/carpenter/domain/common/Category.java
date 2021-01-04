package org.carpenter.domain.common;

import lombok.Getter;
import org.carpenter.domain.goal.GoalRoot;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Category {

    @Id
    private Long id;
    private String title;
    private Boolean published;

    @OneToMany(mappedBy = "category")
    private List<GoalRoot> rootList = new ArrayList<>();
}
