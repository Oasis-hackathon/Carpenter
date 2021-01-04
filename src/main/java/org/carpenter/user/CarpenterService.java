package org.carpenter.user;

import org.carpenter.user.dto.CarpenterJoinDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CarpenterService extends UserDetailsService {
    void save(CarpenterJoinDto joinDto);
}
