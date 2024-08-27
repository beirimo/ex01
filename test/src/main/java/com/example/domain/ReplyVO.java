package com.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;



@Data
public class ReplyVO {
	
	private int rid;
	private int bid;
	private String writer;
	private String contents;
	@JsonFormat(pattern="yyyy년MM월dd일 HH:mm:ss", timezone="Asia/Seoul")
	private String regDate;

	
	

}
