package com.huaxinshengyuan.socknow.service;

import java.util.Collection;
import org.springframework.cache.annotation.Cacheable;


import com.huaxinshengyuan.socknow.domain.User;

public interface UserService {
	@Cacheable("users")
	public Collection<User> findUsers();

}
