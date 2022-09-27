package com.study.springboot.dto;

import lombok.Data;

@Data
public class MemberDto {
	String id;
	String password;
	String phoneNumber;
	String address;
	String registerNumber;
	String gender;
}
