package com.leaf.hrm.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Embeddable
public class SysRoleAuthorityId implements Serializable{
    private Long sysRole;
    private Long authority;

    @Column(name = "sys_role", nullable = false)
    public Long getSysRole() {
        return sysRole;
    }

    public void setSysRole(Long sysRole) {
        this.sysRole = sysRole;
    }

    @Column(name = "authority", nullable = false)
    public Long getAuthority() {
        return authority;
    }

    public void setAuthority(Long authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRoleAuthorityId that = (SysRoleAuthorityId) o;
        return Objects.equals(sysRole, that.sysRole) &&
                Objects.equals(authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sysRole, authority);
    }
}
