package com.leaf.hrm.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Embeddable
public class SysUserSysRoleId implements Serializable{

    private String sysUser;
    private Long sysRole;

    @Column(name = "sys_user", nullable = false)
    public String getSysUser() {
        return sysUser;
    }

    public void setSysUser(String sysUser) {
        this.sysUser = sysUser;
    }

    @Column(name = "sys_role", nullable = false)
    public Long getSysRole() {
        return sysRole;
    }

    public void setSysRole(Long sysRole) {
        this.sysRole = sysRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUserSysRoleId that = (SysUserSysRoleId) o;
        return Objects.equals(sysUser, that.sysUser) &&
                Objects.equals(sysRole, that.sysRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sysUser, sysRole);
    }
}
