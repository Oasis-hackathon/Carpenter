package org.carpenter.domain.recommend;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Builder
    public Recommend(RecommendType type, String keyword, String url) {
        this.type = type;
        this. keyword = keyword;
        this.url = url;
    }
}
