package com.ssafy.enjoytrip.member.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RequestModifyInfoDto {

	private int userId;
	private String username;
	private String password;
	private int gender;
	private int age;
	
}
