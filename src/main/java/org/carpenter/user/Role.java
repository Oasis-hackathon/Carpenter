package org.carpenter.user;

import lombok.Getter;
import org.carpenter.common.RoleName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Entity
public class Role implements GrantedAuthority {

    @Id
    private Long id;
    private RoleName roleName;

    @ManyToOne
    private User user;

    @Override
    public String getAuthority() {
        return roleName.toString();
    }
}
