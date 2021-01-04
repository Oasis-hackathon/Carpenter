package org.carpenter.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.carpenter.user.Carpenter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarpenterJoinDto {
    String email;
    String password;
    String username;
    String nickname;
    Set<String> role;

    @Builder
    public CarpenterJoinDto(String email, String password, String username, String nickname) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.nickname = nickname;
    }

    public Carpenter toEntity(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
        return Carpenter.builder().email(this.email).password(this.password).username(this.username).nickname(this.nickname).build();
    }
}
