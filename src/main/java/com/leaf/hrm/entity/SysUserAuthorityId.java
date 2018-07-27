package com.leaf.hrm.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Embeddable
public class SysUserAuthorityId implements Serializable{
    private String sysUser;
    private Long authority;

    @Column(name = "sys_user", nullable = false,length = 100)
    public String getSysUser() {
        return sysUser;
    }

    public void setSysUser(String sysUser) {
        this.sysUser = sysUser;
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
        SysUserAuthorityId that = (SysUserAuthorityId) o;
        return Objects.equals(sysUser, that.sysUser) &&
                Objects.equals(authority, that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sysUser, authority);
    }
}
