package org.carpenter.user;

import org.carpenter.user.dto.UserJoinDto;
import org.carpenter.user.mapper.UserMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserMapper userMapper;

//    return을 User로 변경하면 UserDetails는 자동으로 다운캐스팅 됨
    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    @Override
    public void save(UserJoinDto joinDto) {
        userRepository.save(userMapper.joinDtoToUser(joinDto));
    }
}
