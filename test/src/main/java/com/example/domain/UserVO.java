package com.example.domain;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class UserVO {
	private String uid;
	private String upass;
	private String uname;
	private Integer state;
	private String email;
	private String birthdate;
	private String gender;
	private String nationality;
	private String phone_number;
	
	//권한
	private String role;

	
	
}
