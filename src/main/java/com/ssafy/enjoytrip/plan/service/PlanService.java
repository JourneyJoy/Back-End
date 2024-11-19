package com.ssafy.enjoytrip.plan.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.enjoytrip.plan.dto.PlanDto;
import com.ssafy.enjoytrip.plan.dto.RequestInsertPlanAttractionDto;
import com.ssafy.enjoytrip.plan.dto.RequestInsertPlanDto;
import com.ssafy.enjoytrip.plan.dto.RequestModifyPlanDto;
import com.ssafy.enjoytrip.plan.mapper.PlanMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor

public class PlanService implements PlanServiceImpl {
	
	private final PlanMapper mapper;

	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public ResponseEntity<?> insertPlan(RequestInsertPlanDto insertDto) throws RuntimeException {
		try {
			mapper.insertPlan(insertDto);
			
			int planId = insertDto.getPlanId();
			List<Integer> attractions = insertDto.getAttractions();
			
			for (Integer attractionId : attractions) {
				RequestInsertPlanAttractionDto dto = RequestInsertPlanAttractionDto.builder()
						.attractionsId(attractionId)
						.planId(planId)
						.build();
				mapper.insertPlanAttraction(dto);
				
			}
			log.info("*** [작성]여행계획::" + insertDto.toString());
			log.info("*** [" + planId + "]여행지ID::" + attractions.toString());
			return ResponseEntity.ok().body("계획 작성 성공");
		} catch (Exception e) {
			log.warn(e.getMessage());
			throw new RuntimeException();
		}
	}

	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public ResponseEntity<?> selectPlan(int planId) throws RuntimeException {
		try {
			List<PlanDto> planList = mapper.selectPlan(planId);
			
			log.info("*** [조회]여행계획::" + planList.toString());
			return ResponseEntity.ok().body(planList);
		} catch (Exception e) {
			log.warn(e.getMessage());
			throw new RuntimeException();
		}
	}
	
	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public ResponseEntity<?> modifyPlan(RequestModifyPlanDto modifyDto) throws RuntimeException {
		try {
			mapper.modifyPlan(modifyDto);
			
			int planId = modifyDto.getPlanId();
			mapper.deletePlanAttraction(planId);

			List<Integer> attractions = modifyDto.getAttractions();
			
			for (Integer attractionId : attractions) {
				RequestInsertPlanAttractionDto dto = RequestInsertPlanAttractionDto.builder()
						.attractionsId(attractionId)
						.planId(planId)
						.build();
				mapper.insertPlanAttraction(dto);
				
			}
			
			log.info("*** [수정]여행계획::" + modifyDto.toString());
			log.info("*** [" + planId + "]여행지ID::" + attractions.toString());
			return ResponseEntity.ok().body("계획 수정 완료");
		} catch (Exception e) {
			log.warn(e.getMessage());
			throw new RuntimeException();
		}
	}

	@Override
	@Transactional(rollbackFor = {SQLException.class})
	public ResponseEntity<?> deletePlan(int planId) throws RuntimeException {
		try {
			mapper.deletePlanAttraction(planId);
			int result = mapper.deletePlan(planId);
			
			if (result == 0) {
				return ResponseEntity.ok().body("계획 삭제 실패");
			}
			
			log.info("*** [삭제]여행계획::" + planId);
			return ResponseEntity.ok().body("계획 삭제 성공");
		} catch (Exception e) {
			log.warn(e.getMessage());
			throw new RuntimeException();
		}
	}

}
