package com.study.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springboot.dto.CommentDto;
import com.study.springboot.dto.MemberDto;
import com.study.springboot.dto.SelfReportDto;
import com.study.springboot.dto.BoardDto;
import com.study.springboot.dto.ChildCommentDto;

@Repository
public class Dao implements IDao {

	@Autowired
	JdbcTemplate tmp;

	@Override
	public List<BoardDto> selectListDao(int page) {
		String query = "select * from titleBoard order by titleId limit ?,?";
		List<BoardDto> dto = tmp.query(query, new BeanPropertyRowMapper<BoardDto>(BoardDto.class), (page - 1) * 5, 5);
		return dto;
	}
	
	@Override
	public int writeDao(String id, String title, String content, String privacy, String password) {
		String query = "insert into titleBoard(id, title, content, privacy, password) values(?,?,?,?,?)";
		int isSuccess = tmp.update(query, id, title, content, privacy, password);
		return isSuccess;
	}

	@Override
	public int selectAndCount() {
		String query = "select count(*) from titleBoard";
		int pageCount = tmp.queryForObject(query, Integer.class);
		return pageCount;
	}

	@Override
	public int deleteDao(String titleId) {
		String query = "delete from titleBoard where titleId = ?";
		int isSuccess = tmp.update(query, Integer.parseInt(titleId));
		return isSuccess;
	}

	@Override
	public List<BoardDto> select(int id) {
		String query = "select * from titleBoard where titleId = ?";
		List<BoardDto> dto = tmp.query(query, new BeanPropertyRowMapper<BoardDto>(BoardDto.class), id);
		return dto;
	}

	@Override
	public int insertTitleIdToComment() {
		String query = "insert into commentBoard(titleId) select titleId from titleBoard";
		int isSuccess = tmp.update(query);
		return isSuccess;
	}

	@Override
	public String selectTitle(int titleId) {
		String query = "select title from titleBoard where titleId =?";
		String title = tmp.queryForObject(query, String.class, titleId);
		return title;
	}

	@Override
	public String selectContent(int titleId) {
		String query = "select content from titleBoard where titleId =?";
		String content = tmp.queryForObject(query, String.class, titleId);
		return content;
	}

	@Override
	public int writeComment(String comment) {
		String query = "insert into commentBoard(comment) values(?)";
		int isSuccess = tmp.update(query, comment);
		return isSuccess;
	}

	@Override
	public int insertMemberInfo(String id, String password, String name, String phoneNumber, String address,
			String registerNumber, String gender) {
		String query = "insert into memberInfo(id, password, name, phoneNumber, address, registerNumber, gender) values(?,?,?,?,?,?,?)";
		int isSuccess = tmp.update(query, id, password, name, phoneNumber, address, registerNumber, gender);
		return isSuccess;
	}

	@Override
	public List<MemberDto> selectID() {
		String query = "select id from memberInfo";
		List<MemberDto> dto = tmp.query(query, new BeanPropertyRowMapper<MemberDto>(MemberDto.class));
		return dto;
	}

	@Override
	public String selectPassword(String id) {
		String query = "select password from memberInfo where id =?";
		String passwordDB = tmp.queryForObject(query, String.class, id);
		return passwordDB;
	}

	@Override
	public String selectName(String id) {
		String query = "select name from memberInfo where id =?";
		String name = tmp.queryForObject(query, String.class, id);
		return name;
	}

	@Override
	public String selectGender(String id) {
		String query = "select gender from memberInfo where id =?";
		String gender = tmp.queryForObject(query, String.class, id);
		return gender;
	}

	@Override
	public String selectPhoneNumber(String id) {
		String query = "select phoneNumber from memberInfo where id =?";
		String phoneNumber = tmp.queryForObject(query, String.class, id);
		return phoneNumber;
	}

	@Override
	public String selectAddress(String id) {
		String query = "select address from memberInfo where id =?";
		String address = tmp.queryForObject(query, String.class, id);
		return address;	
		}

	@Override
	public int insertSelfReport(String selectName, String id, String selectPhoneNumber, String selectAddress, String vaccine,
			String symptom_check, String symptom_date, String test_date, String condition_check, String contact, String submitComplete) {
		String query = "insert into selfreport(name, id, phoneNumber, address, vaccine, symptom_check, symptom_date, test_date, condition_check, contact, submitComplete)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?)";
		int isSuccess = tmp.update(query, selectName, id, selectPhoneNumber, selectAddress, vaccine, symptom_check, symptom_date, 
				test_date, condition_check, contact, submitComplete);
		return isSuccess;
	}

	@Override
	public List<SelfReportDto> selectSelfReport() {
		String query = "select * from selfreport ";
		List<SelfReportDto> dto = tmp.query(query, new BeanPropertyRowMapper<SelfReportDto>(SelfReportDto.class));
		return dto;
	}

	@Override
	public String selectPrivacy(int titleId) {
		String query = "select privacy from titleboard where titleId =?";
		String privacy = tmp.queryForObject(query, String.class, titleId);
		return privacy;	
	}

	@Override
	public String selectCommentPassword(int titleId) {
		String query = "select password from titleboard where titleid =?";
		String commentPassword = tmp.queryForObject(query, String.class, titleId);
		return commentPassword;	
	}

	@Override
	public List<CommentDto> selectCommentList(int titleId) {
		String query = "select * from commentBoard where titleId = ?";
		List<CommentDto> dto = tmp.query(query, new BeanPropertyRowMapper<CommentDto>(CommentDto.class), titleId 
			);
		return dto;
	}
	
	@Override
	public int insertComment(String id, int titleId, String comment) {
		String query="insert into commentboard(id, titleId,comment) value(?,?,?)";
		int isSuccess = tmp.update(query,id, titleId, comment);
		return isSuccess;
	}
	
	@Override
	public int commentDelete(int commentId) {
		String query = "delete from commentBoard where commentId = ?";
		int isSuccess = tmp.update(query,commentId);
		return  isSuccess;
	}
	
	@Override
	public int commentUpdate(String comment, int commentId) {
		String query = "update  commentBoard set comment=? where commentId = ?";
		int isSuccess = tmp.update(query,comment,commentId);
		return  isSuccess;
	}

	@Override
	public int insertChildComment(int commentId, String id, String childComment) {
		String query="insert into childComment(commentId, id, childComment) value(?,?,?)";
		int isSuccess = tmp.update(query, commentId, id, childComment);
		return isSuccess;
	}

	@Override
	public List<ChildCommentDto> selectChildComment(int commentId) {
		String query = "select * from childComment where commentId = ?";
		List<ChildCommentDto> dto = tmp.query(query, new BeanPropertyRowMapper<ChildCommentDto>(ChildCommentDto.class), commentId);
		return dto;
	}
}
