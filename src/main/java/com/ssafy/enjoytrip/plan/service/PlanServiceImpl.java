package com.ssafy.enjoytrip.plan.service;

import org.springframework.http.ResponseEntity;

import com.ssafy.enjoytrip.plan.dto.RequestInsertPlanDto;
import com.ssafy.enjoytrip.plan.dto.RequestModifyPlanDto;

public interface PlanServiceImpl {

	ResponseEntity<?> insertPlan(RequestInsertPlanDto insertDto) throws RuntimeException;
	ResponseEntity<?> selectPlan(int planId) throws RuntimeException;
	ResponseEntity<?> modifyPlan(RequestModifyPlanDto modifyDto) throws RuntimeException;
	ResponseEntity<?> deletePlan(int planId) throws RuntimeException;
	
}
