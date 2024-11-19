package com.ssafy.enjoytrip.board.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.enjoytrip.board.mapper.BoardMapper;
import com.ssafy.enjoytrip.board.dto.BoardDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService implements BoardServiceImpl { // 인터페이스 구현

    private final BoardMapper boardMapper;
    
    @Override
    @Transactional
    public List<BoardDto> findAll() {
    	try {
    		log.info("*** 게시물 목록 불러오기:: ***");		
            return boardMapper.findAll();
        } catch (Exception e) {
        	log.error("게시물 목록을 찾을 수 없습니다.", e);
            throw new RuntimeException("게시물 목록을 찾을 수 없습니다.");
        }
    }
    
    @Override
    @Transactional
    public BoardDto findById(int id) {
    	try {
    		BoardDto board = boardMapper.findById(id);
    		log.info("*** 게시글 불러오기:: " + board.toString() + " *** ");	
    		return board;
    	} catch(Exception e) {
            throw new RuntimeException("게시물을 찾을 수 없습니다.: " + id);
        }
    }

    @Override
    @Transactional
    //TODO : 작성자만 수정 기능 추가
    //TODO : 예외 처리 변경
    public void save(BoardDto board) {
    	try{
    		if (board.getId() == 0) { // ID가 0인 경우 새로 생성
    			log.info("*** 게시글 등록:: " + board.toString() + " *** ");	
                boardMapper.insert(board);
            } else { // 기존 게시글 업데이트
            	log.info("*** 게시글 수정:: " + board.toString() + " *** ");	
                boardMapper.update(board);
            }
    	} catch (Exception e) {
            log.error("게시글 등록 또는 수정 실패", e);
            throw new RuntimeException("글 등록 또는 수정 실패");
         }
    }

    @Override
    @Transactional
    public void delete(int id) {
    	try{
    		log.info("*** 게시글 삭제 성공 *** ");	
    		boardMapper.delete(id);
    	} catch (Exception e) {
            log.error("게시글 삭제 실패", e);
            throw new RuntimeException("게시글 삭제 실패");
        }
    }
}
