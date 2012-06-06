package com.huaxinshengyuan.socknow.userdetails;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.domain.enums.Role;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

public class SocknowUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private final User user;
	
    private  final String role_Hierarchy="ROLE_ADMIN>ROLE_USER ROLE_USER>ROLE_BROWSER";
    public SocknowUserDetails(User user) {
        this.user = user;
    }

	@Override
    public Collection<GrantedAuthority> getAuthorities() {
        Role[] roles = user.getRoles();
        if (roles ==null) return Collections.emptyList();
   
         RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
         roleHierarchy.setHierarchy(role_Hierarchy);
         Collection<? extends GrantedAuthority> roless= roleHierarchy.getReachableGrantedAuthorities(Arrays.<GrantedAuthority>asList(roles));
         List<GrantedAuthority> allroles = new ArrayList<GrantedAuthority>();
         for(GrantedAuthority a: roless)
         {
        	 allroles.add(a);
         }
         return allroles;
    }
  
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }
}
