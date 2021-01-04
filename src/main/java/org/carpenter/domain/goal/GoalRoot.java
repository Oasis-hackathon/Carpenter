package org.carpenter.domain.goal;

import lombok.Getter;
import org.carpenter.domain.common.Category;
import org.carpenter.domain.user.Carpenter;

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
