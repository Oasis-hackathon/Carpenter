package org.carpenter.user.mapper;

import org.carpenter.user.User;
import org.carpenter.user.dto.UserJoinDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User joinDtoToUser(UserJoinDto joinDto);
}
