package com.ssafy.enjoytrip.member.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RequestLoginDto {

	private String email;
	private String password;
}
