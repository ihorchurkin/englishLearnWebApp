package com.churkin.dyplom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.churkin.dyplom.entity.Account;
import com.churkin.dyplom.mapping.AccountMapper;

@Component
public class AccountDAO {
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Account show(int id) {
		return jdbcTemplate.query("SELECT * FROM accounts WHERE idaccounts=?", 
				new Object[] {id}, new AccountMapper()).stream().findAny().orElse(null);
	}
	
	public List<Account> index() {
        return jdbcTemplate.query("SELECT * FROM accounts", new BeanPropertyRowMapper<>(Account.class));
    }
	
	public Account show(String email) {
		return jdbcTemplate.query("SELECT * FROM accounts WHERE email=?", 
				new Object[] {email}, new AccountMapper()).stream().findAny().orElse(null);
	}
	
	public void createAccount(Account account) {
		List<Account> accounts = index();
		
		int num = accounts.size();
		
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		
		System.out.println("num is " + num);
		
		String tableName = "words" + num;
		
		jdbcTemplate.update("INSERT INTO accounts (`email`, `password`, `tablename`) VALUES (?, ?, ?)", account.getEmail(), account.getPassword(), tableName);
		
		jdbcTemplate.execute("CREATE TABLE " + tableName + " (idwords INT NOT NULL AUTO_INCREMENT,"
				+ "english VARCHAR(45) NULL,"
				+ "ukrainian VARCHAR(45) NULL,"
				+ "PRIMARY KEY (idwords))");
	}
}
