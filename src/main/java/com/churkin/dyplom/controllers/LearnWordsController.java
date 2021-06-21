package com.churkin.dyplom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.churkin.dyplom.dao.AccountDAO;
import com.churkin.dyplom.dao.WordDAO;
import com.churkin.dyplom.entity.Account;
import com.churkin.dyplom.entity.Word;

@Controller
@RequestMapping("/learn")
public class LearnWordsController {
	
	private int id;
	
	@Autowired
	private WordDAO wordDao;
	
	@Autowired
	private AccountDAO accountDao;
	
	@GetMapping("/learnWords")
	public String learnForm(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String userName = authentication.getName();
		Account account = accountDao.show(userName);
		
		List<Word> words = wordDao.index(account.getTableName());
		int rand = (int)((Math.random()*words.size())+1);
		
		Word word = new Word();

		id = rand;
		word.setId(rand);
		
		try {
			word.setEnglish(words.get(rand-1).getEnglish());
		}
		catch (IndexOutOfBoundsException ex) {
			return  "redirect:/add/newWord";
		}
		
		model.addAttribute("word", word);
		
		return "/learnWords";
	}
	
	@PostMapping()
	public String click(@ModelAttribute("word") Word word) {
		Word translation = wordDao.show(id);
		
		if (translation.getUkrainian().equals(word.getUkrainian()))
			return "redirect:learn/learnWords";
		else
			return "/incorrect";
	}
}
