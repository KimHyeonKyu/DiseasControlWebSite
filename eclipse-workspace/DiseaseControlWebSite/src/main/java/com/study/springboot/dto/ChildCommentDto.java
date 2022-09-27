package com.study.springboot.dto;

import lombok.Data;

@Data
public class ChildCommentDto {
	int childCommentId;
	int commentId;
	String id;
	String childComment;
}
