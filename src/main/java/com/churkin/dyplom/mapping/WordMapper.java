package com.churkin.dyplom.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.churkin.dyplom.entity.Word;


public class WordMapper implements RowMapper<Word> {

	@Override
	public Word mapRow(ResultSet rs, int rowNum) throws SQLException {
		Word word = new Word();
		
		word.setId(rs.getInt(1));
		word.setEnglish(rs.getString("english"));
		word.setUkrainian(rs.getString("ukrainian"));
		
		return word;
	}

}
