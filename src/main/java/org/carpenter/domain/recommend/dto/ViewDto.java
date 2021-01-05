package org.carpenter.domain.recommend.dto;

import lombok.Data;
import org.carpenter.domain.recommend.RecommendType;

@Data
public class ViewDto {
    private Long id;
    private RecommendType type;
    private String keyword;
    private String url;
}
