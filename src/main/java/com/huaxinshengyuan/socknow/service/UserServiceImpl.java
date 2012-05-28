package com.huaxinshengyuan.socknow.service;

import java.util.Collection;

import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huaxinshengyuan.socknow.domain.Group;
import com.huaxinshengyuan.socknow.domain.Publication;
import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.domain.UserInGroup;
import com.huaxinshengyuan.socknow.domain.UserSecurePublication;
import com.huaxinshengyuan.socknow.domain.enums.Permission;
import com.huaxinshengyuan.socknow.domain.enums.UserType;
import com.huaxinshengyuan.socknow.domain.relation.RelationType;
import com.huaxinshengyuan.socknow.repo.UserRepository;

@Service("userService") @Transactional(readOnly=true)
public class UserServiceImpl implements UserService{
	
	@Autowired private Neo4jOperations template;
	
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

	@Override  @Transactional 
	public UserInGroup joinInGroup(User user,Group group, UserType userType) {
		UserInGroup userInGroup = template.createRelationshipBetween(user, group, UserInGroup.class,  RelationType.UserInGroup, false);
		userInGroup.setUserType(userType);
		template.save(userInGroup);
		return userInGroup;
	}

	@Override @Transactional 
	public UserSecurePublication accessPublication(User user,
			Publication publication, Permission permission) {
		UserSecurePublication securePublication = template.createRelationshipBetween(user, publication, UserSecurePublication.class,  RelationType.UserSecuredPublication, false);
		securePublication.setPermission(permission.name());
		template.save(securePublication);
		return securePublication;
	}

}
