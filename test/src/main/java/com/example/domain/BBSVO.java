package com.example.domain;

public class BBSVO {
	private int bid;
	private String title;
	private String contents;
	private String writer;
	private String regDate;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() { 
		return "BBSVO [bid=" + bid + ", title=" + title + ", contents=" + contents + ", writer=" + writer + ", regDate="
				+ regDate + "]";
	}
	

}
