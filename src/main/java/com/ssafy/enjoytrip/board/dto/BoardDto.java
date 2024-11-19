package com.ssafy.enjoytrip.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class BoardDto {
	
	private int id;
	private String title;
	private String content;
	private String author;
	private String createdAt;
	private String updatedAt;
	private int userId;
	private int type;
}
