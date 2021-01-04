package org.carpenter.common;


import lombok.Getter;

@Getter
public enum RoleName {
    ADMIN("ADMIN"), CUSTOMER("CUSTOMER");

    private String roleName;

    RoleName(String roleName) {
        this.roleName = roleName;
    }

}
