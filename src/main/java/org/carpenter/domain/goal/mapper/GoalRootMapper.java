package org.carpenter.domain.goal.mapper;

import org.carpenter.config.MapStructConfiguration;
import org.carpenter.domain.common.EntityMapper;
import org.carpenter.domain.goal.GoalRoot;
import org.carpenter.domain.goal.dto.UpdateRootDto;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfiguration.class)
public interface GoalRootMapper extends EntityMapper<GoalRoot, UpdateRootDto> {
}
