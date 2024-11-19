package com.ssafy.enjoytrip.plan.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PlanDto {

	private int planId;
	private int userId;
	private String planTitle;
	private String createdAt;
	private String startDate;
	private String endDate;
	private int attractionNo;
	private String attractionTitle;
	private double latitude;
	private double longitude;
	private String addr1;
	private String addr2;
}
