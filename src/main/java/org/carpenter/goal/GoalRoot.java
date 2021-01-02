package org.carpenter.goal;

import org.carpenter.common.Category;
import org.carpenter.user.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

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
    private User user;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "goalRoot")
    private Set<GoalNode> goalNodeSet;
}
