package com.churkin.dyplom.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.churkin.dyplom.entity.Account;

public class AccountMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		
		account.setId(rs.getInt(1));
		account.setEmail(rs.getString("email"));
		account.setPassword(rs.getString("password"));
		account.setTableName(rs.getString("tablename"));
		
		return account;
	}

}
