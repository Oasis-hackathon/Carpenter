package org.carpenter.domain.user;

import org.carpenter.domain.user.dto.JoinDto;
import org.carpenter.domain.user.dto.UpdateDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CarpenterService extends UserDetailsService {
    UpdateDto getCarpenter(String email);
    void save(JoinDto joinDto);
    UpdateDto update(UpdateDto dto);
    void delete(UpdateDto dto);
}
