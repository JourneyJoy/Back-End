package com.ssafy.enjoytrip.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.member.dto.RequestLoginDto;
import com.ssafy.enjoytrip.member.dto.RequestModifyInfoDto;
import com.ssafy.enjoytrip.member.dto.RequestRegisterDto;
import com.ssafy.enjoytrip.member.service.MemberServiceImpl;
import com.ssafy.enjoytrip.util.JWTUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberController {
	
	private final MemberServiceImpl service;
	private final JWTUtil jwtUtil;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RequestRegisterDto registerDto) {			
		return service.register(registerDto);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody RequestLoginDto dto) {
		return service.login(dto);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> mypageInfo(@PathVariable("userId") int userId) {
		return service.mypageInfo(userId);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<?> modifyInfo(@RequestBody RequestModifyInfoDto modifyInfoDto) {
		return service.modifyInfo(modifyInfoDto);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteInfo(@PathVariable("userId") int userId) {
		return service.deleteInfo(userId);
	}
}
