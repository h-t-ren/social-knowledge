package com.huaxinshengyuan.socknow.service;

import java.util.Collection;

import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.repo.UserRepository;

@Service("userService") @Transactional(readOnly=true)
public class UserServiceImpl implements UserService{
	
	@Autowired private UserRepository userRepository;

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

}
