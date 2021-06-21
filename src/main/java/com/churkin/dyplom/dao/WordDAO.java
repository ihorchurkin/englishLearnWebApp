package com.churkin.dyplom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.churkin.dyplom.entity.Account;
import com.churkin.dyplom.entity.Word;
import com.churkin.dyplom.mapping.WordMapper;

@Component
public class WordDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private AccountDAO accountDao;
	
	public Word show(int id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String userName = authentication.getName();
		Account account = accountDao.show(userName);
		
		return jdbcTemplate.query("SELECT * FROM " + account.getTableName() + " WHERE idwords=?", 
				new Object[] {id}, new WordMapper()).stream().findAny().orElse(null);
	}
	
	public void save(Word word) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String userName = authentication.getName();
		Account account = accountDao.show(userName);
		
        jdbcTemplate.update("INSERT INTO " + account.getTableName() + " (`english`, `ukrainian`) VALUES (?, ?)",
        		word.getEnglish(), word.getUkrainian());
    }
	
	public List<Word> index(String tableWord) {
        return jdbcTemplate.query("SELECT * FROM " + tableWord , new BeanPropertyRowMapper<>(Word.class));
    }
}
