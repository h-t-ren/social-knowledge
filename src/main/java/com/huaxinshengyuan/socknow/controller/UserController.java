package com.huaxinshengyuan.socknow.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huaxinshengyuan.socknow.domain.xml.Users;
import com.huaxinshengyuan.socknow.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/list", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	public @ResponseBody Users getAllUsers() {
		Users users = new Users();
		users.setUser(userService.findUsers());
		return users;
	}

	@RequestMapping(value = "/user/list", method = RequestMethod.GET, headers="Accept=application/html, application/xhtml+xml")
	public String  getAllUsers(Model model) {
		Users users = new Users();
		users.setUser(userService.findUsers());
		model.addAttribute("users", users);
		return "user/list";
	}
}
