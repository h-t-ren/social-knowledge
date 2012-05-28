package com.huaxinshengyuan.socknow.service;

import java.util.Collection;

import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.repo.UserRepository;

@Service("userService") @Transactional(readOnly=true)
public class UserServiceImpl implements UserService{
	
	@Autowired private UserRepository userRepository;
    private static final String SALT = "yibayan";
	@Override
	public Collection<User> findUsers() {
		return IteratorUtil.asCollection(userRepository.findAll());
	}

	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	@Override @Transactional 
	public void save(User user) {
			userRepository.save(user);
	}

	@Override  @Transactional 
	public void register(User user) {
		user.setPassword(encode(user.getPassword()));
		userRepository.save(user);
		
	}
    private String encode(String password) {
    	Md5PasswordEncoder md5 = new Md5PasswordEncoder();
    	String md5Hash = md5.encodePassword(password, SALT);
        return  md5Hash;
    }

}
