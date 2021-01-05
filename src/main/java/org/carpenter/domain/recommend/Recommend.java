package org.carpenter.domain.recommend;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.carpenter.domain.goal.GoalRoot;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Recommend {

//    형태소 분석 라이브러리로 키워드 추출
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private  RecommendType type;
    private String keyword;
    private String url;

    @ManyToOne
    private GoalRoot goalRoot;

    @Builder
    public Recommend(RecommendType type, String keyword, String url, GoalRoot goalRoot) {
        this.type = type;
        this. keyword = keyword;
        this.url = url;
        this.goalRoot = goalRoot;
    }
}
