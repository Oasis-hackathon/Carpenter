package org.carpenter.domain.goal;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.carpenter.domain.goal.dto.UpdateRootDto;
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
    @GeneratedValue
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
    private List<GoalNode> goalNodeList = new ArrayList<>();

    @Builder
    public GoalRoot(String title, String description, Boolean published, LocalDate startDate, LocalDate endDate, Carpenter carpenter, Category category) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.startDate = startDate;
        this.endDate = endDate;
        this.carpenter = carpenter;
        this.category = category;
    }

    public void update(UpdateRootDto dto) {
        this.title = dto.getTitle();
        this.description = dto.getDescription();
        this.published = dto.getPublished();
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
    }
}
