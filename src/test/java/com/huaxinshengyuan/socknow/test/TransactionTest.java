package com.huaxinshengyuan.socknow.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.domain.enums.Role;
import com.huaxinshengyuan.socknow.repo.UserRepository;
import com.huaxinshengyuan.socknow.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/socknow-test-context.xml"})
@DirtiesContext
public class TransactionTest {

    @Autowired UserRepository userRepository;
    @Autowired UserService userService;
  

    @Test @Transactional @Rollback(false)
    public void testBefriendUsers() {
    	
    	
    	
    	User hongtao = new User("hongtao", "hongtao", "hongtao", Role.ROLE_USER,Role.ROLE_ADMIN);
    	userService.register(hongtao);
        //  final User me = userRepository.save(new User("hongtao", "hongtao", "hongtao", Role.ROLE_USER,Role.ROLE_ADMIN));
        //   final User you = userRepository.save(new User("you", "you", "you"));
      //   userRepository.addFriend("you", userRepository.getUserFromSession());
     //    final User loaded = userRepository.findOne(me.getId());
    	
    	
    	
    	for(User u: userRepository.findAll())
    	{
    		 System.out.println("user name: " + u.getLogin() +", pass: " + u.getPassword());
    		 for(Role role : u.getRoles())
    		 {
    			 System.out.println("Role: " + role.getAuthority());
    		 }
    	}
    	
    	
        
       //  assertEquals(1,loaded.getFriends().size());
    }


}
