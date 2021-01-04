package org.carpenter.domain.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.carpenter.domain.user.Carpenter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @ManyToOne
    private Carpenter carpenter;

    @Override
    public String getAuthority() {
        return roleName.getRoleName();
    }

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }
}
