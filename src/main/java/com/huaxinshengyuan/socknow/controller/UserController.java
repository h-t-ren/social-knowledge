package com.huaxinshengyuan.socknow.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.huaxinshengyuan.socknow.domain.xml.Users;
import com.huaxinshengyuan.socknow.service.UserService;


@Controller
public class UserController {
	

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired private UserService userService;
	

	@RequestMapping(value = LogicVeiws.USER_LIST, method = RequestMethod.GET, headers=HttpHeaders.HTML)
	public String  getAllUsers(Model model) {
		Users users = new Users();
		users.setUser(userService.findUsers());
		model.addAttribute("users", users);
		return LogicVeiws.USER_LIST;
	}
	
	/** Data binding still doesn't work! so go to spring webflow**/
	/**
	@RequestMapping(value = LogicVeiws.USER_EDIT, method = RequestMethod.GET, headers="Accept=application/html, application/xhtml+xml")
	public String loadUser(@PathVariable Long id, Model model) {
	model.addAttribute("user", userService.findById(id));
	return LogicVeiws.USER_FORM;
	}
	@RequestMapping(value = LogicVeiws.USER_EDIT, method = RequestMethod.POST, headers="Accept=application/html, application/xhtml+xml")
	public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result,Model model) {
	userService.save(user);
	return "redirect:"+LogicVeiws.USER_LIST;
	}
	**/
	
	

	

}
