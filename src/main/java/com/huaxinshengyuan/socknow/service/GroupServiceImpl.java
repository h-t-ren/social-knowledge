package com.huaxinshengyuan.socknow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.huaxinshengyuan.socknow.domain.Group;
import com.huaxinshengyuan.socknow.domain.GroupSecurePublication;
import com.huaxinshengyuan.socknow.domain.Publication;
import com.huaxinshengyuan.socknow.domain.enums.Permission;
import com.huaxinshengyuan.socknow.domain.relation.RelationType;
import com.huaxinshengyuan.socknow.repo.GroupRepository;

@Service("groupService") @Transactional(readOnly=true)
public class GroupServiceImpl implements GroupService {
	
	@Autowired private Neo4jOperations template;
	
	@Autowired private GroupRepository groupRepository;

	@Override @Transactional
	public void save(Group group) {
		groupRepository.save(group);

	}

	@Override @Transactional
	public GroupSecurePublication accessPublication(Group group,
			Publication publication, Permission permission) {
		GroupSecurePublication securePublication = template.createRelationshipBetween(group, publication, GroupSecurePublication.class,  RelationType.GroupSecuredPublication, false);
		securePublication.setPermission(permission);
		template.save(securePublication);
		return securePublication;
	
	}

}
