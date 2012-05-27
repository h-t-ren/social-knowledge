package com.huaxinshengyuan.socknow.service;

import java.util.Collection;

import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.repo.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired private UserRepository userRepository;

	@Override
	public Collection<User> findUsers() {
		return IteratorUtil.asCollection(userRepository.findAll());
	}

}
