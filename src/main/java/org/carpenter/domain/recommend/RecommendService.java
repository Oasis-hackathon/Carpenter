package org.carpenter.domain.recommend;

import org.carpenter.domain.goal.GoalRoot;
import org.carpenter.domain.recommend.dto.ViewDto;

public interface RecommendService {

    ViewDto getRecommend(Long rootId);
    void save(GoalRoot root);
}
