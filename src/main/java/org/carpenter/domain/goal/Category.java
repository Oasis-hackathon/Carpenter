package org.carpenter.domain.goal;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Boolean published;

    @OneToMany(mappedBy = "category")
    private List<GoalRoot> rootList = new ArrayList<>();

    @Builder
    public Category(String title, Boolean published) {
        this.title=title;
        this.published=published;
    }
}
