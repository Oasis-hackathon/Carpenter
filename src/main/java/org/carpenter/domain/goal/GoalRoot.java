package org.carpenter.domain.goal;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.carpenter.domain.common.Category;
import org.carpenter.domain.user.Carpenter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class GoalRoot {

    @Id
    private Long id;
    private String title;
    private String description;
    private Boolean published;
    private LocalDate startDate;
    private LocalDate endDate;

    @Builder
    public GoalRoot(String title, String description, Boolean published, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @ManyToOne
    private Carpenter carpenter;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "goalRoot", cascade = CascadeType.PERSIST)
    private List<GoalNode> goalNodeList = new ArrayList<>();
}
