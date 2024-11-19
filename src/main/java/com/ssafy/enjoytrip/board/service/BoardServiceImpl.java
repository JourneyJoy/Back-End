package com.ssafy.enjoytrip.board.service;

import com.ssafy.enjoytrip.board.dto.BoardDto;

import java.util.List;

public interface BoardServiceImpl {
    List<BoardDto> findAll();
    BoardDto findById(int id);
    void save(BoardDto board);
    void delete(int id);
}