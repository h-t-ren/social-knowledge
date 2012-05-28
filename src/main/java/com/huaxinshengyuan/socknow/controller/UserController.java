package com.huaxinshengyuan.socknow.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaxinshengyuan.socknow.domain.User;
import com.huaxinshengyuan.socknow.domain.xml.Users;
import com.huaxinshengyuan.socknow.service.UserService;


@Controller
public class UserController {
	
	private static final String USER_LIST= "/user/list", USER_EDIT="/user/edit/{id}",USER_FORM="/user/form";
	private static final String[] DISALLOWED_UPDATE_FIELDS={"password"};
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired private UserService userService;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request)
	{

        //  binder.setDisallowedFields(DISALLOWED_UPDATE_FIELDS);
   
	}
	
	
    /*********************HTTP******************/
	@RequestMapping(value = USER_LIST, method = RequestMethod.GET, headers="Accept=application/html, application/xhtml+xml")
	public String  getAllUsers(Model model) {
		Users users = new Users();
		users.setUser(userService.findUsers());
		model.addAttribute("users", users);
		return USER_LIST;
	}
	
	@RequestMapping(value = USER_EDIT, method = RequestMethod.GET, headers="Accept=application/html, application/xhtml+xml")
	public String loadUser(@PathVariable Long id, Model model) {
	model.addAttribute("user", userService.findById(id));
	return USER_FORM;
	}
	@RequestMapping(value = USER_EDIT, method = RequestMethod.POST, headers="Accept=application/html, application/xhtml+xml")
	public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result,Model model) {
	System.out.println("---id: " + user.getId() +", name:" + user.getName() +"password: " + user.getPassword());
	//userService.save(user);
	return "redirect:"+USER_LIST;
	}
	
	
	
	
	/*************REST METHOD***********/

	@RequestMapping(value = USER_LIST, method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody Users getAllUsers() {
		Users users = new Users();
		users.setUser(userService.findUsers());
		return users;
	}

	@RequestMapping(value = USER_EDIT, method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody User getUser(@PathVariable Long id, Model model) {
		return userService.findById(id);
	}
	
	@RequestMapping(value = USER_EDIT, method = RequestMethod.PUT, headers="Accept=application/xml, application/json")
	public  @ResponseBody User  saveUser(@PathVariable Long id, @RequestBody User user) {
		log.debug("save user");
		userService.save(user);
		return user;
	}
	
	
	

}
