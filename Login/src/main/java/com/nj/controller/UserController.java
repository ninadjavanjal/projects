package com.nj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nj.model.User;
import com.nj.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="sUser",method=RequestMethod.GET )
	public ModelAndView sUser(@ModelAttribute User user) {

		return new ModelAndView("userForm","userForm", new User());
	}

	@RequestMapping(value="saveUser",method=RequestMethod.POST )
	public ModelAndView saveUser(@ModelAttribute User user) {
		if (user.getId() == null) {

			userService.saveUser(user);
		} else {
			userService.updateUser(user);
		}
		return new ModelAndView("redirect:getUsersList");
	}

	@RequestMapping("getUser")
	public ModelAndView getUser(@ModelAttribute Long id) {
		userService.getUser(id);
		return new ModelAndView("redirect:getUsersList");
	}

	@RequestMapping(value = { "getUsersList", "/" })
	public ModelAndView getUsersList() {
		List<User> userList = userService.getUsersList();
		return new ModelAndView("userList", "userList", userList);
	}

}
