package com.leaf.hrm.daoImpl;

import com.leaf.hrm.dao.SysUserDAO;
import com.leaf.hrm.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Repository
public class SysUserDAOImpl implements SysUserDAO {
    @Autowired
    private EntityManager entityManager;
    @Override
    public SysUser getSysUserByUsername(String username) {
        return entityManager.find(SysUser.class,username);
    }
}
