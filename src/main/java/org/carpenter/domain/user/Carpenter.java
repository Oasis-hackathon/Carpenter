package org.carpenter.domain.user;

import lombok.*;
import org.carpenter.domain.board.Board;
import org.carpenter.domain.board.Comment;
import org.carpenter.domain.common.RoleName;
import org.carpenter.domain.goal.GoalRoot;
import org.carpenter.domain.user.dto.UpdateDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
@Entity
public class Carpenter implements UserDetails {

//    TODO : Embedded Type 적용 고민하기

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String username;
    private String nickname;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    @OneToMany(mappedBy = "carpenter", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Role> roleSet;

    @OneToMany(mappedBy = "carpenter", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<GoalRoot> rootSet;

    @OneToMany(mappedBy = "carpenter", cascade = CascadeType.PERSIST)
    private Set<Board> boardSet;

    @OneToMany(mappedBy = "carpenter", cascade = CascadeType.PERSIST)
    private Set<Comment> commentSet;

    @Builder
    public Carpenter(String email, String password, String username, String nickname) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.nickname = nickname;
        this.createdTime = LocalDateTime.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> result = new HashSet<>();
        Role role = Role.builder().roleName(RoleName.CUSTOMER).build();
        result.add(role);
        return result;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void update(UpdateDto dto) {
        if (!dto.getPassword().isEmpty()) {
            this.password = dto.getPassword();
        }
        this.nickname = dto.getNickname();
        this.updatedTime = LocalDateTime.now();
    }
}