package com.leaf.hrm.dao;

import com.leaf.hrm.entity.SysUser;

/**
 * @author : Rusiru on 27-Jul-18.
 */
public interface SysUserDAO {

    SysUser getSysUserByUsername(String username);
}
