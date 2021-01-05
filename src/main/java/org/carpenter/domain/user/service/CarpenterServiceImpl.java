package org.carpenter.domain.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.carpenter.domain.user.Carpenter;
import org.carpenter.domain.user.CarpenterRepository;
import org.carpenter.domain.user.dto.JoinDto;
import org.carpenter.domain.user.dto.UpdateDto;
import org.carpenter.domain.user.mapper.CarpenterMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class CarpenterServiceImpl implements CarpenterService {

    private final CarpenterRepository carpenterRepository;
    private final CarpenterMapper carpenterMapper;
    private final PasswordEncoder passwordEncoder;

    //    로그인 정보에서 usernameparameter를 참조해서 DB에서 사용자 정보 탐색, 암호화된 비밀번호 비교
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Carpenter carpenter = carpenterRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
        return new org.springframework.security.core.userdetails.User(carpenter.getEmail(), carpenter.getPassword(), carpenter.getAuthorities());
    }

    @Override
    public UpdateDto getCarpenter(String email) {
        Carpenter carpenter = carpenterRepository.findByEmail(email).get();
        UpdateDto dto = carpenterMapper.toDto(carpenter);
        dto.setPassword("");
        return dto;
    }

    @Override
    public void save(JoinDto joinDto) {
        Carpenter carpenter = joinDto.toEntity(passwordEncoder);
        carpenterRepository.save(carpenter);
    }

    @Override
    public UpdateDto update(UpdateDto dto) {
        Carpenter carpenter = carpenterRepository.findByEmail(dto.getEmail()).get();
        if (!dto.getPassword().isEmpty()) {
            dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        carpenter.update(dto);
        Carpenter updatedEntity = carpenterRepository.save(carpenter);
        return carpenterMapper.toDto(updatedEntity);
    }

    @Override
    public void delete(UpdateDto dto) {
        carpenterRepository.deleteByEmail(dto.getEmail());
    }


}
