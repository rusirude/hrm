package com.leaf.hrm.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GranularSecurityConfig extends GlobalMethodSecurityConfiguration {

//    @Autowired
//    private ApplicationContext appContext;
//
//    @Override
//    protected MethodSecurityExpressionHandler createExpressionHandler() {
//        DefaultMethodSecurityExpressionHandler methodSecurityExpressionHandler = new DefaultMethodSecurityExpressionHandler();
//        methodSecurityExpressionHandler.setRoleHierarchy(roleHierarchy());
//        methodSecurityExpressionHandler.setApplicationContext(appContext);
//        return methodSecurityExpressionHandler;
//    }
//
//    @Bean
//    public RoleHierarchy roleHierarchy() {
//        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
//        roleHierarchy.setHierarchy("ROLE_ANONYMOUS");
//        return roleHierarchy;
//    }
//
//    @Bean
//    public RoleVoter roleVoter() {
//        return new RoleHierarchyVoter(roleHierarchy());
//    }

    @Bean
    @SuppressWarnings("unchecked")
    public FilterRegistrationBean filterRegistrationBean() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}