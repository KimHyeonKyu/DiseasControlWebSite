package com.study.springboot.dto;

import lombok.Data;

@Data
public class BoardDto {
	int titleId;
	String id;
	String title;
	String content;
	String comment;
	String privacy;
	String password;
}
