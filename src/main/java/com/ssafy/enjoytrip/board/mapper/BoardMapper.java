package com.ssafy.enjoytrip.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.board.dto.BoardDto;

@Mapper
public interface BoardMapper {
    List<BoardDto> findAll();
    BoardDto findById(int id);
    int insert(BoardDto board);
    int update(BoardDto board);
    int delete(int id);
}
