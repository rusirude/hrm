package com.leaf.hrm.entity;

import javax.persistence.*;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Entity
@Table(name = "sys_role_authority")
public class SysRoleAuthority {
    private SysRoleAuthorityId sysRoleAuthorityId;
    private SysRole sysRole;
    private Authority authority;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "sysRole", column = @Column(name = "sys_role", nullable = false)),
            @AttributeOverride(name = "authority", column = @Column(name = "authority", nullable = false))
    })
    public SysRoleAuthorityId getSysRoleAuthorityId() {
        return sysRoleAuthorityId;
    }

    public void setSysRoleAuthorityId(SysRoleAuthorityId sysRoleAuthorityId) {
        this.sysRoleAuthorityId = sysRoleAuthorityId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sys_role", referencedColumnName = "id", insertable = false, updatable = false)
    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authority", referencedColumnName = "id", insertable = false, updatable = false)
    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
