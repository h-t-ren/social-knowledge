package com.huaxinshengyuan.socknow.repo;


import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.huaxinshengyuan.socknow.domain.SocknowUserDetails;
import com.huaxinshengyuan.socknow.domain.User;


public interface SocknowUserDetailsService extends UserDetailsService {
    @Override
    SocknowUserDetails loadUserByUsername(String login) throws UsernameNotFoundException, DataAccessException;

    User getUserFromSession();

   
}
