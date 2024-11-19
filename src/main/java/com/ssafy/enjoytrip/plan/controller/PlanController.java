package com.ssafy.enjoytrip.plan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.plan.dto.RequestInsertPlanDto;
import com.ssafy.enjoytrip.plan.dto.RequestModifyPlanDto;
import com.ssafy.enjoytrip.plan.service.PlanServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/plan")
public class PlanController {
	
	private final PlanServiceImpl service;
	
	@PostMapping
	ResponseEntity<?> insertPlan(@RequestBody RequestInsertPlanDto insertDto) {
		try {
			return service.insertPlan(insertDto);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body("계획 작성 실패");
		}
	}
	
	@GetMapping("/{planId}")
	ResponseEntity<?> selectPlan(@PathVariable("planId") int planId) {
		try {
			return service.selectPlan(planId);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body("계획 작성 실패");
		}
	}
	
	@PutMapping("/{planId}")
	ResponseEntity<?> modifyPlan(@RequestBody RequestModifyPlanDto modifyDto) {
		try {
			return service.modifyPlan(modifyDto);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body("계획 수정 실패");
		}
	}
	
	@DeleteMapping("/{planId}")
	ResponseEntity<?> deletePlan(@PathVariable("planId") int planId) {
		try {
			return service.deletePlan(planId);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body("계획 삭제 실패");
		}
	}
}
