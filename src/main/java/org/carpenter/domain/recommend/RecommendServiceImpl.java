package org.carpenter.domain.recommend;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import lombok.RequiredArgsConstructor;
import org.carpenter.domain.goal.GoalRoot;
import org.carpenter.domain.recommend.dto.ViewDto;
import org.carpenter.domain.recommend.mapper.RecommendMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class RecommendServiceImpl implements RecommendService {

    private final RecommendRepository recommendRepository;
    private final RecommendMapper recommendMapper;
    private final Komoran komoran = new Komoran(DEFAULT_MODEL.LIGHT);

    @Value("${videoUrl}")
    private String videoUrl;

    @Value("${productUrl}")
    private String productUrl;

    @Override
    public ViewDto getRecommend(Long rootId) {
        Recommend recommend = recommendRepository.findByGoalRoot(rootId);
        return recommendMapper.toDto(recommend);
    }

    @Override
    public void save(GoalRoot root) {
        List<String> result = komoran.analyze(root.getTitle()).getNouns();
        StringBuffer sb = new StringBuffer();

        for (String keyword :
                result) {
            sb.append(keyword);
        }
        sb.trimToSize();
        String keywords = sb.toString();

        Recommend videoRecommend = Recommend.builder().keyword(keywords).type(RecommendType.VIDEO).url(videoUrl + keywords).goalRoot(root).build();
        Recommend productRecommend = Recommend.builder().keyword(keywords).type(RecommendType.PRODUCT).url(productUrl + keywords).goalRoot(root).build();

        recommendRepository.save(videoRecommend);
        recommendRepository.save(productRecommend);
    }
}
