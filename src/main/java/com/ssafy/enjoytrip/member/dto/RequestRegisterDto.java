package com.ssafy.enjoytrip.member.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RequestRegisterDto {

	private String username;
	private String email;
	private String password;
	private int gender;
	private int age;
	
}
