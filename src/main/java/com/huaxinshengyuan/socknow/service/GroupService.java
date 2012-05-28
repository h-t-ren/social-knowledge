package com.huaxinshengyuan.socknow.service;
import com.huaxinshengyuan.socknow.domain.Group;
import com.huaxinshengyuan.socknow.domain.GroupSecurePublication;
import com.huaxinshengyuan.socknow.domain.Publication;
import com.huaxinshengyuan.socknow.domain.enums.Permission;


public interface GroupService {
	
	public void save(Group group);
	public  GroupSecurePublication accessPublication(Group group,Publication publication,Permission permission);

}
