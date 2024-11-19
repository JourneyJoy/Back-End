package com.ssafy.enjoytrip.plan.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RequestInsertPlanDto {

	private int planId;
	private int userId;
	private String planTitle;
	private LocalDate startDate;
	private LocalDate endDate;
	private List<Integer> attractions;
}
