package org.carpenter.user;

import org.carpenter.user.dto.UserJoinDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void save(UserJoinDto joinDto);
}
