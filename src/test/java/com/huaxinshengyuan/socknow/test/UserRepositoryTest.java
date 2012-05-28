package com.huaxinshengyuan.socknow.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.domain.index.FieldIndex;
import com.huaxinshengyuan.socknow.domain.mapper.PublicationPermission;
import com.huaxinshengyuan.socknow.repo.UserRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/socknow-test-context.xml"})
@DirtiesContext
public class UserRepositoryTest {

    @Autowired UserRepository userRepository;
	private Logger log = LoggerFactory.getLogger(this.getClass());
    @Test
    public void testUserRepo() {
    	User user = userRepository.findByPropertyValue(FieldIndex.LOGIN,"yangyang");
    	log.debug("user name: " + user.getName() +", pass: " + user.getPassword() +",id=" +user.getId());
    	List<PublicationPermission> pp= userRepository.getPublicationPermission(user);
    	for(PublicationPermission p:pp)
    	{
    		log.debug("p: " + p.getPublication().getTitle() + ", per: " +p.getPerssion()) ;
    	}
    	
    }


}
