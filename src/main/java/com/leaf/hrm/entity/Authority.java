package com.leaf.hrm.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Entity
@Table(name = "authority")
public class Authority {

    private Long id;
    private String authorityCode;
    private String code;
    private String description;
    private Status status;
    private Set<SysRoleAuthority> sysRoleAuthorities = new HashSet<>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "authority_code", nullable = false, length = 20, unique = true)
    public String getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(String authorityCode) {
        this.authorityCode = authorityCode;
    }

    @Column(name = "code", nullable = false, length = 15, unique = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "description", nullable = false, length = 150)
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "authority")
    public Set<SysRoleAuthority> getSysRoleAuthorities() {
        return sysRoleAuthorities;
    }

    public void setSysRoleAuthorities(Set<SysRoleAuthority> sysRoleAuthorities) {
        this.sysRoleAuthorities = sysRoleAuthorities;
    }
}
