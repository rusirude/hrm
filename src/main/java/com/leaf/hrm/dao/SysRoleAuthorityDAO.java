package com.leaf.hrm.dao;

import com.leaf.hrm.entity.SysRole;
import com.leaf.hrm.entity.SysRoleAuthority;

import java.util.List;

/**
 * @author : Rusiru on 27-Jul-18.
 */
public interface SysRoleAuthorityDAO {
    /**
     * Get Distinct SysRoleAuthority by Role
     * @param sysRoles - System Roles Entity List
     * @return List of SysRoleAuthority
     */
    List<SysRoleAuthority> getSysRoleAuthorityBySysRoles(List<SysRole> sysRoles);
}
