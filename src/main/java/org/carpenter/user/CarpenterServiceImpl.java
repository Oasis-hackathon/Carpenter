package org.carpenter.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.carpenter.user.dto.CarpenterJoinDto;
import org.carpenter.user.mapper.CarpenterMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class CarpenterServiceImpl implements CarpenterService {

    private final CarpenterRepository carpenterRepository;
    private final CarpenterMapper carpenterMapper;
    private final PasswordEncoder passwordEncoder;

//    로그인 정보에서 usernameparameter를 참조해서 DB에서 사용자 정보 탐색, 암호화된 비밀번호 비교
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Carpenter user = carpenterRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getAuthorities());
    }

    @Override
    public void save(CarpenterJoinDto joinDto) {
        Carpenter mappedUser = carpenterMapper.toEntity(joinDto);
        Carpenter user = joinDto.toEntity(passwordEncoder);
        carpenterRepository.save(user);
    }

}
