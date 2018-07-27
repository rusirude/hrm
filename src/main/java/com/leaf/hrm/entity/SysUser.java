package com.leaf.hrm.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Rusiru on 22-Jul-18.
 */
@Entity
@Table(name = "sys_user")
public class SysUser extends CommonEntity{

    private String username;
    private String password;
    private Status status;
    private Integer restPassword;
    private Set<SysUserSysRole> sysUserSysRoles = new HashSet<>(0);

    @Id
    @Column(name = "username", nullable = false, unique = true , length = 100)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Column(name = "reset_password")
    public Integer getRestPassword() {
        return restPassword;
    }

    public void setRestPassword(Integer restPassword) {
        this.restPassword = restPassword;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sysUser")
    public Set<SysUserSysRole> getSysUserSysRoles() {
        return sysUserSysRoles;
    }

    public void setSysUserSysRoles(Set<SysUserSysRole> sysUserSysRoles) {
        this.sysUserSysRoles = sysUserSysRoles;
    }

}

