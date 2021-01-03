package org.carpenter.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.carpenter.board.Board;
import org.carpenter.board.Comment;
import org.carpenter.goal.GoalRoot;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements UserDetails {

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

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Role> roleSet;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<GoalRoot> rootSet;

    @OneToMany(mappedBy = "user")
    private Set<Board> boardSet;

    @OneToMany(mappedBy = "user")
    private Set<Comment> commentSet;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> result = new HashSet<>();
        Iterator iterator = roleSet.iterator();
        while (iterator.hasNext()) {
            Role role = (Role) iterator.next();
            result.add(role);
        }
        return result;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
