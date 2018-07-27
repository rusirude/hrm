package com.leaf.hrm.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Rusiru on 22-Jul-18.
 */
@Entity
@Table(name = "sys_role")
public class SysRole extends CommonEntity{

    private Long id;
    private String code;
    private String description;
    private Status status;
    private Set<SysUserSysRole> sysUserSysRoles = new HashSet<>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "code", nullable = false, length = 15,unique = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "description", nullable = false,length = 150)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sysRole")
    public Set<SysUserSysRole> getSysUserSysRoles() {
        return sysUserSysRoles;
    }

    public void setSysUserSysRoles(Set<SysUserSysRole> sysUserSysRoles) {
        this.sysUserSysRoles = sysUserSysRoles;
    }
}
