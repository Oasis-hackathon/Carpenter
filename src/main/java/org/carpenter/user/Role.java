package org.carpenter.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.carpenter.common.RoleName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue
    private Long id;
    private RoleName roleName;

    @ManyToOne
    private Carpenter carpenter;

    @Override
    public String getAuthority() {
        return roleName.getRoleName();
    }

    @Builder
    public Role(RoleName roleName) {
        this.roleName = roleName;
    }
}
