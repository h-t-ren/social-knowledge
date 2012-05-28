package com.huaxinshengyuan.socknow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.socknow.domain.Group;
import com.huaxinshengyuan.socknow.repo.GroupRepository;

@Service("groupService") @Transactional(readOnly=true)
public class GroupServiceImpl implements GroupService {
	
	@Autowired private GroupRepository groupRepository;

	@Override @Transactional
	public void save(Group group) {
		groupRepository.save(group);

	}

}
