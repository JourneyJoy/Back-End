package com.ssafy.enjoytrip.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.board.dto.BoardDto;
import com.ssafy.enjoytrip.board.service.BoardService;
import com.ssafy.enjoytrip.util.JWTUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;
    private final JWTUtil jwtUtil;
    
    /*
     *  TODO : 
     *  viewType 추가
     *  hit 추가
     *  수정날짜 업데이트 추가
     *  JWT 추가
     */
    
    @GetMapping
    public ResponseEntity<List<BoardDto>> getAllBoards() {
        List<BoardDto> boards = service.findAll();
        return new ResponseEntity<>(boards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDto> getBoard(@PathVariable int id) {
        BoardDto board = service.findById(id);
        if(board != null) {
        	return ResponseEntity.ok(board);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BoardDto> createBoard(@RequestBody BoardDto boardDto) {
        service.save(boardDto);
        return new ResponseEntity<>(boardDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardDto> updateBoard(@PathVariable int id, @RequestBody BoardDto boardDto) {
        boardDto.setId(id);
        service.save(boardDto);
        return ResponseEntity.ok(boardDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

