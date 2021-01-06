package org.carpenter.domain.user.dto;

import lombok.Data;

@Data
public class UpdateDto {
    private Long id;
    private String email;
    private String password;
    private String username;
    private String nickname;
}
