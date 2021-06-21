package com.churkin.dyplom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.churkin.dyplom.dao.AccountDAO;
import com.churkin.dyplom.dao.WordDAO;
import com.churkin.dyplom.entity.Account;
import com.churkin.dyplom.entity.Word;

@Controller
public class MainController {
	
	@Autowired
	private AccountDAO accountDao;
	
	@Autowired
	private WordDAO wordDao;
	
	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String userName = authentication.getName();
		Account account = accountDao.show(userName);
		
		List<Word> list = wordDao.index(account.getTableName());
		
	    model.addAttribute("words", list);
		
		return "/index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		
		return "/login";
	}
}

