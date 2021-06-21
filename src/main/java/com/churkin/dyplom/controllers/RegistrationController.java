package com.churkin.dyplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.churkin.dyplom.dao.AccountDAO;
import com.churkin.dyplom.entity.Account;

@Controller
@RequestMapping("/reg")
public class RegistrationController {
	@Autowired
	private AccountDAO accountDao;
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("account", new Account());
		
		return "/registration";
	}
	
	@PostMapping()
	public String register(@ModelAttribute("account") Account account) {
		System.out.println(account);
		accountDao.createAccount(account);
		
		return "redirect:/login";
		
	}
}
