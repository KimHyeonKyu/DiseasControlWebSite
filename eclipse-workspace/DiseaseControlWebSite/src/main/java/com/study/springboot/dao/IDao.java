package com.study.springboot.dao;

import java.util.List;

import com.study.springboot.dto.CommentDto;
import com.study.springboot.dto.MemberDto;
import com.study.springboot.dto.SelfReportDto;
import com.study.springboot.dto.BoardDto;
import com.study.springboot.dto.ChildCommentDto;

public interface IDao {
	public List<BoardDto> selectListDao(int page);
	public int selectAndCount();
	public int deleteDao(String id);
	public List<BoardDto> select(int id);
	public int insertTitleIdToComment();
	public String selectTitle(int titleId);
	public String selectContent(int titleId);
	public int writeComment(String comment);
	public int insertMemberInfo(String id, String password, String name, String phoneNumber, String address,
			String registerNumber, String gender);
	public List<MemberDto> selectID();
	public String selectPassword(String id);
	public String selectName(String id);
	public String selectGender(String id);
	public String selectPhoneNumber(String id);
	public String selectAddress(String id);
	public int insertSelfReport(String selectName, String id,  String selectPhoneNumber, String selectAddress, String vaccine,
			String symptom_check, String symptom_date, String test_date, String condition_check, String contact, String submitComplete);
	public List<SelfReportDto> selectSelfReport();
	public int writeDao(String id, String title, String content, String privacy, String password);
	public String selectPrivacy(int titleId);
	public String selectCommentPassword(int titleId);
	public List<CommentDto>selectCommentList(int titleId);
	public int insertComment(String id, int titleId, String comment);
	public int commentDelete(int commentId);
	public int commentUpdate(String comment, int commentId);
	public int insertChildComment(int commentId, String id, String childComment);
	public List<ChildCommentDto> selectChildComment(int commentId);
}
