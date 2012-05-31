package com.huaxinshengyuan.socknow.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.domain.UserInGroup;
import com.huaxinshengyuan.socknow.domain.index.FieldIndex;
import com.huaxinshengyuan.socknow.domain.mapper.PublicationPermission;
import com.huaxinshengyuan.socknow.repo.GroupRepository;
import com.huaxinshengyuan.socknow.repo.UserRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/socknow-test-context.xml"})
@Transactional
public class UserRepositoryTest {

    @Autowired UserRepository userRepository;
    @Autowired GroupRepository groupRepository;
	private Logger log = LoggerFactory.getLogger(this.getClass());
    @Test @Transactional(readOnly=true)
    public void testUserRepo() {
    	User user = userRepository.findByPropertyValue(FieldIndex.LOGIN,"yangyang");
    	
    	
    	//log.debug("---------: " + user.getUserInGroups().size());
    	for(UserInGroup ug: user.getUserInGroups())
    	{
    		log.debug("---------: " + ug.getGroup().getName());
    	}
    	
    
    	log.debug("user name: " + user.getName() +", pass: " + user.getPassword() +",id=" +user.getId());
    	List<PublicationPermission> pp= userRepository.getPublicationPermission(user);
    	for(PublicationPermission p:pp)
    	{
    		log.debug("p: " + p.getPublication().getTitle() + ", per: " +p.getPerssion());
    	}
    	
    	
    	
    	for (User u:userRepository.findAllByPropertyValue("name", "Hongtao Ren"))
    	{
    		log.debug("---------: " + u.getName());
    	}
    }


}
