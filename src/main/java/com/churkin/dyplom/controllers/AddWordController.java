package com.churkin.dyplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.churkin.dyplom.dao.WordDAO;
import com.churkin.dyplom.entity.Word;

@Controller
@RequestMapping("/add")
public class AddWordController {
	@Autowired
	private WordDAO wordDao;
	
	@GetMapping("/newWord")
	public String addForm(Model model) {
		model.addAttribute("word", new Word());
		
		return "/addWord";
	}
	
	@PostMapping()
	public String newWord(@ModelAttribute("word") Word word) {
		wordDao.save(word);
		
		return "redirect:";
	}
}
