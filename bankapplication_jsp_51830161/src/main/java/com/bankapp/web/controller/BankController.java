package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entities.User;
import com.bankapp.model.service.UserService;

@Controller
public class BankController {

	@Autowired
	private UserService userService;

	@Bean
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}

	@GetMapping(path = "/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping(path = "admin")
	public String admin() {
		return "admin";
	}

	@GetMapping(path = "mgr")
	public String mgr() {
		return "mgr";
	}

	@RequestMapping("allusers")
	public ModelAndView getAllUsers(ModelAndView mv) {
		mv.setViewName("allusers");
		mv.addObject("users", userService.findAll());
		return mv;
	}

	@PostMapping("adduser")
	public String addusers(User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addingusers";
		} else {
			System.out.println(user.getId());

			if (user.getId() == null)
				userService.addUser(user);
			else
				userService.findAll();
			return "redirect:allusers";
		}
	}

	@RequestMapping(value = "adduser", method = RequestMethod.GET)
	public ModelAndView adduserGet(User user, ModelAndView mv) {
		mv.addObject("users", new User());
		mv.setViewName("addusers");
		return mv;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest req) {
		long id = Long.parseLong(req.getParameter("id"));
		userService.deleteUser(id);
		return "redirect:allusers";
	}

}
