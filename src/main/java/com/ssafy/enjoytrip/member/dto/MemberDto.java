package com.ssafy.enjoytrip.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class MemberDto {

	private int id;
	private String username;
	private String email;
	private String password;
	private String createdAt;
	private int gender;
	private int age;
}
