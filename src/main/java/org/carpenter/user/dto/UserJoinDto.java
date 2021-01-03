package org.carpenter.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserJoinDto {
    String email;
    String password;
    String username;
    String nickname;
    Set<String> role;
}
