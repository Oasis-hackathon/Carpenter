package org.carpenter.domain.user.mapper;

import org.carpenter.domain.common.EntityMapper;
import org.carpenter.domain.user.Carpenter;
import org.carpenter.domain.user.dto.UpdateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarpenterMapper extends EntityMapper<Carpenter, UpdateDto> {

}
