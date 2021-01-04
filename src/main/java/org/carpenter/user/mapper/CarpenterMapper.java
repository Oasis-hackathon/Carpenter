package org.carpenter.user.mapper;

import org.carpenter.user.Carpenter;
import org.carpenter.user.dto.CarpenterJoinDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarpenterMapper {
    Carpenter toEntity(CarpenterJoinDto joinDto);
}
