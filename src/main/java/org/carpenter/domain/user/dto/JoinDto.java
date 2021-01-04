package org.carpenter.domain.user.dto;

import lombok.Data;
import org.carpenter.domain.user.Carpenter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Data
public class JoinDto {
    String email;
    String password;
    String username;
    String nickname;
    Set<String> role;

    public Carpenter toEntity(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
        return Carpenter.builder().email(this.email).password(this.password).username(this.username).nickname(this.nickname).build();
    }
}
