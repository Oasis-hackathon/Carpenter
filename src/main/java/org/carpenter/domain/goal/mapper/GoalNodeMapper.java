package org.carpenter.domain.goal.mapper;

import org.carpenter.config.MapStructConfiguration;
import org.carpenter.domain.common.EntityMapper;
import org.carpenter.domain.goal.GoalNode;
import org.carpenter.domain.goal.dto.UpdateNodeDto;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfiguration.class)
public interface GoalNodeMapper extends EntityMapper<GoalNode, UpdateNodeDto> {
}
