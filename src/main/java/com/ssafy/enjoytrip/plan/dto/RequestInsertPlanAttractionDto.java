package com.ssafy.enjoytrip.plan.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class RequestInsertPlanAttractionDto {

	private int attractionsId;
	private int planId;
}
