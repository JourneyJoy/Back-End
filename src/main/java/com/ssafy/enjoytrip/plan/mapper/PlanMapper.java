package com.ssafy.enjoytrip.plan.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.plan.dto.PlanDto;
import com.ssafy.enjoytrip.plan.dto.RequestInsertPlanAttractionDto;
import com.ssafy.enjoytrip.plan.dto.RequestInsertPlanDto;
import com.ssafy.enjoytrip.plan.dto.RequestModifyPlanDto;

@Mapper
public interface PlanMapper {

	void insertPlan(RequestInsertPlanDto insertDto) throws SQLException;
	void insertPlanAttraction(RequestInsertPlanAttractionDto insertAttractionDto) throws SQLException;
	List<PlanDto> selectPlan(int planId) throws SQLException;
	int modifyPlan(RequestModifyPlanDto modifyDto) throws SQLException;
	int deletePlan(int planId) throws SQLException;
	int deletePlanAttraction(int planId) throws SQLException;
}
