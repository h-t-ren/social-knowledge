package com.huaxinshengyuan.socknow.service;

import java.util.Collection;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import com.huaxinshengyuan.socknow.domain.Group;
import com.huaxinshengyuan.socknow.domain.Publication;
import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.domain.UserInGroup;
import com.huaxinshengyuan.socknow.domain.UserSecurePublication;
import com.huaxinshengyuan.socknow.domain.enums.Permission;
import com.huaxinshengyuan.socknow.domain.enums.UserType;

public interface UserService {
	
	@Cacheable(value="usersCache")
	public Collection<User> findUsers();
	
	//@Cacheable(value="userCache", key="#id")
	public User findById(Long id);
	
	@CacheEvict(value="usersCache", allEntries=true)
	public void save(User user);
	
	public void register(User user);
	
	public  UserInGroup joinInGroup(User user,Group group,UserType userType);

	public  UserSecurePublication accessPublication(User user,Publication publication,Permission permission);
	
	public void makeFriends(User u1,User u2);
	
	public List<User> findFriends(User u);
}
