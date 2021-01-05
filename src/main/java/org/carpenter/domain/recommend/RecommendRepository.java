package org.carpenter.domain.recommend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {
    Recommend findByGoalRoot(Long rootId);
}
