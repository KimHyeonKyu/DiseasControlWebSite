package com.study.springboot.dto;

import lombok.Data;

@Data
public class SelfReportDto {
	int report_id;
	String id;
	String name;
	String phoneNumber;
	String address;
	String vaccine;
	String symptom_check;
	String symptom_date;
	String test_date;
	String condition_check;
	String contact;
	String regdate;
	String submitComplete;
}
