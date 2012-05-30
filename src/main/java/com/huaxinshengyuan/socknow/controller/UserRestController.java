package com.huaxinshengyuan.socknow.controller;


import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.domain.UserInGroup;
import com.huaxinshengyuan.socknow.domain.mapper.PublicationPermission;
import com.huaxinshengyuan.socknow.domain.rest.Attr;
import com.huaxinshengyuan.socknow.domain.rest.Data;
import com.huaxinshengyuan.socknow.domain.rest.Entity;
import com.huaxinshengyuan.socknow.domain.rest.OEntity;
import com.huaxinshengyuan.socknow.domain.rest.Users;
import com.huaxinshengyuan.socknow.repo.UserRepository;
import com.huaxinshengyuan.socknow.service.UserService;


@Controller
public class UserRestController {
	

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired private UserService userService;
	@Autowired private UserRepository userRepository;

	@RequestMapping(value = LogicRequest.USER_LIST, method = RequestMethod.GET, headers=HttpHeaders.JSON_XML)
	public @ResponseBody Users getAllUsers() {
		Users users = new Users();
		users.setUser(userService.findUsers());
		return users;
	}

	@RequestMapping(value = LogicRequest.USER_PARM, method = RequestMethod.GET, headers=HttpHeaders.JSON_XML)
	public @ResponseBody Entity getUser(@RequestParam("id") Long id, Model model) {
		User user = userService.findById(id);
		Entity entity = new Entity();
		entity.setDetails_html("User: id = " + user.getId() +", name: " + user.getName());
		Data data = new Data();
		data.setId(user.getId());
		data.setName(user.getName());
		
		Collection<Attr> attributes = new Vector<Attr>();
	
		
		Attr attr = new Attr();
		attr.setId("groups");
		attr.setName("In group");
		Collection<OEntity> oEntities = new Vector<OEntity>();
		for(UserInGroup ug : user.getUserInGroups())
		{
			OEntity oEntity = new OEntity();
			oEntity.setId(ug.getGroup().getId());
			oEntity.setName(ug.getGroup().getName());
			oEntities.add(oEntity);
		}
		attr.setValues(oEntities);
		

		
		Attr attr1 = new Attr();
		attr1.setId("Friends");
		attr1.setName("friend");
		Collection<OEntity> oEntitiesa = new Vector<OEntity>();
		for(User f : userService.findFriends(user))
		{
			OEntity oEntity = new OEntity();
			oEntity.setId(f.getId());
			oEntity.setName(f.getName());
			oEntitiesa.add(oEntity);
		}
		attr1.setValues(oEntitiesa);
		
		attributes.add(attr1);
		
		
		
		
		Attr attr2 = new Attr();
		attr2.setId("Publication");
		attr2.setName("Publication");
		Collection<OEntity> oEntitiesb = new Vector<OEntity>();
		List<PublicationPermission> pp= userRepository.getPublicationPermission(user);
		for(PublicationPermission d : pp)
		{
			OEntity oEntity = new OEntity();
			oEntity.setId(d.getPublication().getId());
			oEntity.setName(d.getPublication().getTitle());
			oEntitiesb.add(oEntity);
		}
		attr2.setValues(oEntitiesb);
		
		attributes.add(attr2);
		
		
		
		
		
		
		
		
		data.setAttributes(attributes);
		entity.setData(data);
		
		return entity;
	}
	
	@RequestMapping(value = LogicRequest.USER_ID, method = RequestMethod.PUT, headers=HttpHeaders.JSON_XML)
	public  @ResponseBody User  saveUser(@PathVariable Long id, @RequestBody User user) {
		userService.save(user);
		return user;
	}
	
	
	

}
