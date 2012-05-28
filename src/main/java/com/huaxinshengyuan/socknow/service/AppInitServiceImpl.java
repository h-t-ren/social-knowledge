package com.huaxinshengyuan.socknow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.socknow.domain.Group;
import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.domain.enums.Role;
import com.huaxinshengyuan.socknow.domain.enums.UserType;



@Service("appInitService") @Transactional
public class AppInitServiceImpl implements AppInitService {

	@Autowired UserService userService;
	@Autowired GroupService groupService;
	
	@Override
	public void init() {
		
		
		//Create Hongtao's family
		Group hongtaoGroup = new Group("hongtao_family", Role.ROLE_ADMIN);
		groupService.save(hongtaoGroup);
		
		User hongtao = new User("hongtao", "Hongtao Ren", "hongtao", Role.ROLE_ADMIN, Role.ROLE_USER);
		userService.register(hongtao);
		userService.joinInGroup(hongtao, hongtaoGroup, UserType.CREATOR);
		
		User yangyang = new User("yangyang", "Haoyang Ren", "yangyang", Role.ROLE_USER);
		userService.register(yangyang);
		userService.joinInGroup(yangyang, hongtaoGroup, UserType.USER);
		
		User yifang = new User("yifang", "Yifang Shi", "yifang", Role.ROLE_USER);
		userService.register(yifang);
		userService.joinInGroup(yifang, hongtaoGroup, UserType.USER);
			
		
		//Create Tieju's lab
		Group tiejuLab = new Group("tieju_lab", Role.ROLE_USER);
		groupService.save(tiejuLab);
		
		
		User tieju = new User("tieju", "Tieju Ma", "tieju", Role.ROLE_ADMIN, Role.ROLE_USER);
		userService.register(tieju);
		userService.joinInGroup(tieju, tiejuLab, UserType.CREATOR);
		
		User hongbin = new User("hongbin", "Hongbin Yan", "hongbin", Role.ROLE_USER);
		userService.register(hongbin);
		userService.joinInGroup(hongbin, tiejuLab, UserType.USER);
		
		
		
	}

}
