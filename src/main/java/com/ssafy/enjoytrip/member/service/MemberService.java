package com.ssafy.enjoytrip.member.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.enjoytrip.member.dto.MemberDto;
import com.ssafy.enjoytrip.member.dto.RequestLoginDto;
import com.ssafy.enjoytrip.member.dto.RequestModifyInfoDto;
import com.ssafy.enjoytrip.member.dto.RequestRegisterDto;
import com.ssafy.enjoytrip.member.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService implements MemberServiceImpl {
	
	private final MemberMapper mapper;

	@Override
	@Transactional
	public ResponseEntity<?> register(RequestRegisterDto registerDto) {
		try {			
			mapper.register(registerDto);
			log.info("*** 회원가입 완료::" + registerDto.toString() + "***");
			return ResponseEntity.ok().body("회원가입 완료");
		} catch (Exception e) {
			// TODO: handle exception
			log.warn(e.getMessage());
			return ResponseEntity.badRequest().body("잘못된 접근입니다.");
		}
	}

	@Override
	@Transactional
	public ResponseEntity<?> login(RequestLoginDto loginDto) {
		try {			
			MemberDto member = mapper.login(loginDto);
			
			log.info("*** 로그인::" + member.toString() + "***");				

			return ResponseEntity.ok().body("로그인 성공");
		} catch (Exception e) {
			// TODO: handle exception
			log.warn(e.getMessage());
			return ResponseEntity.badRequest().body("잘못된 접근입니다.");
		}
	}

	@Override
	@Transactional
	public ResponseEntity<?> mypageInfo(int userId) {
		try {			
			MemberDto member = mapper.mypageInfo(userId);
			
			log.info("*** [조회]마이페이지::" + member.toString() + "***");				

			return ResponseEntity.ok().body(member);
		} catch (Exception e) {
			// TODO: handle exception
			log.warn(e.getMessage());
			return ResponseEntity.badRequest().body("잘못된 접근입니다.");
		}
	}

	@Override
	@Transactional
	public ResponseEntity<?> modifyInfo(RequestModifyInfoDto modifyInfoDto) {
		try {			
			int result = mapper.modifyInfo(modifyInfoDto);
			
			if (result == 0) {
				return ResponseEntity.badRequest().body("수정 실패");
			}

			return ResponseEntity.ok().body("수정 성공");
		} catch (Exception e) {
			// TODO: handle exception
			log.warn(e.getMessage());
			return ResponseEntity.badRequest().body("잘못된 접근입니다.");
		}
	}

	@Override
	@Transactional
	public ResponseEntity<?> deleteInfo(int userId) {
		try {			
			int result = mapper.deleteInfo(userId);
			
			if (result == 0) {
				return ResponseEntity.badRequest().body("삭제 실패");
			}

			return ResponseEntity.ok().body("삭제 성공");
		} catch (Exception e) {
			// TODO: handle exception
			log.warn(e.getMessage());
			return ResponseEntity.badRequest().body("잘못된 접근입니다.");
		}
	}

}
