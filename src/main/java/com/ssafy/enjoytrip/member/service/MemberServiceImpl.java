package com.ssafy.enjoytrip.member.service;

import org.springframework.http.ResponseEntity;

import com.ssafy.enjoytrip.member.dto.RequestLoginDto;
import com.ssafy.enjoytrip.member.dto.RequestModifyInfoDto;
import com.ssafy.enjoytrip.member.dto.RequestRegisterDto;


public interface MemberServiceImpl {

	ResponseEntity<?> register(RequestRegisterDto registerDto);
	ResponseEntity<?> login(RequestLoginDto loginDto);
	ResponseEntity<?> mypageInfo(int userId);
	ResponseEntity<?> modifyInfo(RequestModifyInfoDto modifyInfoDto);
	ResponseEntity<?> deleteInfo(int userId);
	
}
