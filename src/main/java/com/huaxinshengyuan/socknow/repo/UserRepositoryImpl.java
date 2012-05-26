package com.huaxinshengyuan.socknow.repo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.huaxinshengyuan.socknow.domain.SocknowUserDetails;
import com.huaxinshengyuan.socknow.domain.User;

@Service("userRepository")
public class UserRepositoryImpl implements SocknowUserDetailsService {

    @Autowired
    private Neo4jOperations template;

    @Override
    public SocknowUserDetails loadUserByUsername(String login) throws UsernameNotFoundException, DataAccessException {
        
    	//System.out.println("-----------------");
    	final User user = findByLogin(login);
        if (user==null) throw new UsernameNotFoundException("Username not found: "+login);
        return new SocknowUserDetails(user);
    }

    private User findByLogin(String login) {
        return  template.lookup(User.class,"login",login).to(User.class).single();
    }

    @Override
    public User getUserFromSession() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof SocknowUserDetails) {
            SocknowUserDetails userDetails = (SocknowUserDetails) principal;
            return userDetails.getUser();
        }
        return null;
    }

   
    void setUserInSession(User user) {
        SecurityContext context = SecurityContextHolder.getContext();
        SocknowUserDetails userDetails = new SocknowUserDetails(user);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, user.getPassword(),userDetails.getAuthorities());
        context.setAuthentication(authentication);

    }

  
}
