package com.churkin.dyplom.entity;

public class Word {
	private int id;
	
	private String english;
	
	private String ukrainian;
	
	public Word() { }

	public Word(String english, String ukrainian) {
		this.english = english;
		this.ukrainian = ukrainian;
	}
	
	public Word(int id, String english, String ukrainian) {
		super();
		this.id = id;
		this.english = english;
		this.ukrainian = ukrainian;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getUkrainian() {
		return ukrainian;
	}

	public void setUkrainian(String ukrainian) {
		this.ukrainian = ukrainian;
	}

	@Override
	public String toString() {
		return "Word [id=" + id + ", english=" + english + ", ukrainian=" + ukrainian + "]";
	}
	
	
}
