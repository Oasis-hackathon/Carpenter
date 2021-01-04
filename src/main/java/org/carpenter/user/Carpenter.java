package org.carpenter.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.carpenter.board.Board;
import org.carpenter.board.Comment;
import org.carpenter.common.RoleName;
import org.carpenter.goal.GoalRoot;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
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

    @OneToMany(mappedBy = "carpenter")
    private Set<Board> boardSet;

    @OneToMany(mappedBy = "carpenter")
    private Set<Comment> commentSet;

    @Builder
    public Carpenter(String email, String password, String username, String nickname) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.nickname = nickname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> result = new HashSet<>();
        Role role = Role.builder().roleName(RoleName.ADMIN).build();
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
}
