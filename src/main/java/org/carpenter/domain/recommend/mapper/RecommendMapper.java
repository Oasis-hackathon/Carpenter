package org.carpenter.domain.recommend.mapper;

import org.carpenter.config.MapStructConfiguration;
import org.carpenter.domain.common.EntityMapper;
import org.carpenter.domain.recommend.Recommend;
import org.carpenter.domain.recommend.dto.ViewDto;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfiguration.class)
public interface RecommendMapper extends EntityMapper<Recommend, ViewDto> {
}
