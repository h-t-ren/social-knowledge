package com.huaxinshengyuan.socknow.service;

import java.util.Collection;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;


import com.huaxinshengyuan.socknow.domain.User;

public interface UserService {
	
	@Cacheable(value="usersCache")
	public Collection<User> findUsers();
	
	//@Cacheable(value="userCache", key="#id")
	public User findById(Long id);
	
	@CacheEvict(value="usersCache", allEntries=true)
	public void save(User user);
	
	public void register(User user);

}
