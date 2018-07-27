package com.leaf.hrm.serviceImpl;

import com.leaf.hrm.dao.SysRoleAuthorityDAO;
import com.leaf.hrm.dao.SysUserDAO;
import com.leaf.hrm.entity.SysRole;
import com.leaf.hrm.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : Rusiru on 22-Jul-18.
 */
@Service
public class CustomUserDetailsService  implements UserDetailsService{


    SysUserDAO sysUserDAO;
    SysRoleAuthorityDAO sysRoleAuthorityDAO;

    @Autowired
    public CustomUserDetailsService(SysUserDAO sysUserDAO, SysRoleAuthorityDAO sysRoleAuthorityDAO) {
        this.sysUserDAO = sysUserDAO;
        this.sysRoleAuthorityDAO = sysRoleAuthorityDAO;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            SysUser sysUser = sysUserDAO.getSysUserByUsername(username);
            return new User(sysUser.getUsername(), sysUser.getPassword(), getGrantedAuthoritiesForUser(sysUser));
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Set<GrantedAuthority> getGrantedAuthoritiesForUser(SysUser user) {
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        List<SysRole> sysRoles = new ArrayList<>();
        user.getSysUserSysRoles()
                .forEach(sysUserSysRole -> {
                    sysRoles.add(sysUserSysRole.getSysRole());
                });
        if (! sysRoles.isEmpty()) {
            sysRoleAuthorityDAO.getSysRoleAuthorityBySysRoles(sysRoles)
                    .stream()
                    .forEach(roleAuthority -> {
                        grantedAuthoritySet.add(new SimpleGrantedAuthority(roleAuthority.getAuthority().getAuthorityCode()));
                    });
        }
        return grantedAuthoritySet;
    }
}
