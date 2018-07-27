package com.leaf.hrm.entity;

import javax.persistence.*;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Entity
@Table(name = "sys_user_authority")
public class SysUserAuthority {
    private SysUserAuthorityId sysUserAuthorityId;
    private SysUser sysUser;
    private Authority authority;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "sysUser", column = @Column(name = "sys_user", nullable = false)),
            @AttributeOverride(name = "authority", column = @Column(name = "authority", nullable = false))
    })
    public SysUserAuthorityId getSysUserAuthorityId() {
        return sysUserAuthorityId;
    }

    public void setSysUserAuthorityId(SysUserAuthorityId sysUserAuthorityId) {
        this.sysUserAuthorityId = sysUserAuthorityId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sys_user", referencedColumnName = "username", insertable = false, updatable = false)
    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
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
