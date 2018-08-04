package com.leaf.hrm.serviceImpl;

import com.leaf.hrm.dao.SysUserDAO;
import com.leaf.hrm.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Service
public class CustomAuthManager implements AuthenticationManager{

    private CustomUserDetailsService customUserDetailsService;
    private SysUserDAO sysUserDAO;

    @Autowired
    public CustomAuthManager(CustomUserDetailsService customUserDetailsService, SysUserDAO sysUserDAO) {
        this.customUserDetailsService = customUserDetailsService;
        this.sysUserDAO = sysUserDAO;
    }

    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String authType = request.getParameter("auth_type");
            if (authType != null) {
                if (authType.equals("mobile")) {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    SysUser sysUser = sysUserDAO.getSysUserByUsername(username);

                    if (sysUser != null) {
                        if (password.equals(sysUser.getPassword())) {
                            return retrieveToken(sysUser);
                        } else {
                            throw new BadCredentialsException("Invalid credentials");
                        }

                    } else {
                        throw new BadCredentialsException("Invalid credentials");
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

    private UsernamePasswordAuthenticationToken retrieveToken(SysUser sysUser) throws Exception {

        Set<GrantedAuthority> grantedAuthoritySet = customUserDetailsService.getGrantedAuthoritiesForUser(sysUser);

        if (!grantedAuthoritySet.isEmpty()) {
            return new UsernamePasswordAuthenticationToken(sysUser.getUsername(), sysUser.getPassword(), grantedAuthoritySet);
        } else {
            throw new Exception();
        }
    }
}
