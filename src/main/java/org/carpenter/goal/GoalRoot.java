package org.carpenter.goal;

import lombok.Getter;
import org.carpenter.common.Category;
import org.carpenter.user.Carpenter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Entity
public class GoalRoot {

    @Id
    private Long id;
    private String title;
    private String description;
    private Boolean published;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private Carpenter carpenter;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "goalRoot", cascade = CascadeType.PERSIST)
    private Set<GoalNode> goalNodeSet;
}
