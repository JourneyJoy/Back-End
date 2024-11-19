package com.ssafy.enjoytrip.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.member.dto.MemberDto;
import com.ssafy.enjoytrip.member.dto.RequestLoginDto;
import com.ssafy.enjoytrip.member.dto.RequestModifyInfoDto;
import com.ssafy.enjoytrip.member.dto.RequestRegisterDto;

@Mapper
public interface MemberMapper {

	void register(RequestRegisterDto registerDto) throws Exception;
	MemberDto login(RequestLoginDto loginDto) throws Exception;
	MemberDto mypageInfo(int userId) throws Exception;
	int modifyInfo(RequestModifyInfoDto modifyInfoDto) throws Exception;
	int deleteInfo(int userId) throws Exception;
}
