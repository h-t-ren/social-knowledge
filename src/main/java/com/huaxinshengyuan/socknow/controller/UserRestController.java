package com.huaxinshengyuan.socknow.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.domain.xml.Users;
import com.huaxinshengyuan.socknow.service.UserService;


@Controller
public class UserRestController {
	

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired private UserService userService;

	@RequestMapping(value = LogicVeiws.USER_LIST, method = RequestMethod.GET, headers=HttpHeaders.JSON_XML)
	public @ResponseBody Users getAllUsers() {
		Users users = new Users();
		users.setUser(userService.findUsers());
		return users;
	}

	@RequestMapping(value = LogicVeiws.USER_EDIT, method = RequestMethod.GET, headers=HttpHeaders.JSON_XML)
	public @ResponseBody User getUser(@PathVariable Long id, Model model) {
		return userService.findById(id);
	}
	
	@RequestMapping(value = LogicVeiws.USER_EDIT, method = RequestMethod.PUT, headers=HttpHeaders.JSON_XML)
	public  @ResponseBody User  saveUser(@PathVariable Long id, @RequestBody User user) {
		userService.save(user);
		return user;
	}
	
	
	

}
