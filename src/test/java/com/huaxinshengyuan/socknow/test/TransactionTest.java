package com.huaxinshengyuan.socknow.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.repo.UserRepository;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/socknow-test-context.xml"})
@DirtiesContext
public class TransactionTest {

    @Autowired UserRepository userRepository;
  

    @Test
    public void testBefriendUsers() {
        final User me = userRepository.save(new User("hongtao", "hongtao", "hongtao", User.Roles.ROLE_USER));
      //  final User you = userRepository.save(new User("you", "you", "you"));
      //   userRepository.addFriend("you", userRepository.getUserFromSession());
         final User loaded = userRepository.findOne(me.getId());
         System.out.println("user name: " + loaded.getLogin() +", pass: " + loaded.getPassword());
       //  assertEquals(1,loaded.getFriends().size());
    }


}
