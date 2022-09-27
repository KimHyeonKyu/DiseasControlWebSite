package com.study.springboot;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.dao.IDao;
import com.study.springboot.dto.CommentDto;
import com.study.springboot.dto.MemberDto;

@Controller
public class MyController {

	@Autowired
	IDao dao;

	@RequestMapping("/")
	public String initailizePage() {
		
		return "redirect:homeCheckLog";
	}
	
	@RequestMapping("/homeCheckLog")
	public String homeCheckLogPage() {

		return "homeCheckLog";
	}
	
	@RequestMapping("/home")
	public String homePage() {
		
		return "home";
	}
	
	@RequestMapping("/selfReport")
	public String selfReportPage(HttpSession session, Model model) {
		
		String id = (String) session.getAttribute("id");
		String name = dao.selectName(id);
		String gender = dao.selectGender(id);
		String phoneNumber = dao.selectPhoneNumber(id);
		String address = dao.selectAddress(id);
		
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("phoneNumber", phoneNumber);
		model.addAttribute("address", address);
		
		return "selfReport";
	}
	
	@RequestMapping("/submitSelfReport")
	public String submitSelfReport(HttpServletRequest request, Model model, HttpSession session) {

		String vaccineCheck = "";
		String symtomChCheck = "";
		String symtomDateCheck = "";
		String testDateCheck = "";
		String conditionChCheck = "";
		String contactCheck = "";
		
		String vaccine = request.getParameter("vaccine");
		String symptom_check = request.getParameter("symptom_check");
		String symptom_date = request.getParameter("symptom_date");
		String test_date = request.getParameter("test_date");
		String condition_check = request.getParameter("condition_check");
		String contact = request.getParameter("contact");
		
		model.addAttribute("vaccine", vaccine);
		
		if(vaccine.equals("vaccine")) {
			vaccineCheck = "백신 접종 상황을 선택해 주세요";
			model.addAttribute("vaccineCheck", vaccineCheck);
			return "selfReport";
		}else if(symptom_check == null){
			symtomChCheck = "증상 여부를 선택해 주세요";
			model.addAttribute("symtomChCheck", symtomChCheck);
			return "selfReport";
		}else if(symptom_date.isBlank()) {
			symtomDateCheck = "증상 발생일을 입력해 주세요";
			model.addAttribute("symtomDateCheck", symtomDateCheck);
			return "selfReport";
		}else if(test_date.isBlank()) {
			testDateCheck = "양성 판정 검사일을 입력해 주세요";
			model.addAttribute("testDateCheck", testDateCheck);
			return "selfReport";
		}else if(condition_check == null) {
			conditionChCheck = "기저질환 증상 유무를 선택해 주세요";
			model.addAttribute("conditionChCheck", conditionChCheck);
			return "selfReport";
		}else if(contact.equals("blank")) {
			contactCheck = "알림방법을 입력해 주세요";
			model.addAttribute("contactCheck", contactCheck);
			return "selfReport";
		}
		String id = (String)session.getAttribute("id");
		String submitComplete = "Success";
		
		session.setAttribute("submitComplete", submitComplete);
		dao.insertSelfReport(dao.selectName(id),id ,dao.selectPhoneNumber(id), dao.selectAddress(id),
				vaccine, symptom_check, symptom_date, test_date, condition_check, contact, submitComplete);
		
		return "selfReportSuccess";
	}
	
	@RequestMapping("/selfReportSuccess")
	public String selfReportSuccessPage() {
		
		return "selfReportSuccess";
	}
	
	@RequestMapping("/selfReportList")
	public String selfReportListPage(Model model) {
		model.addAttribute("list", dao.selectSelfReport());
		return "selfReportList";
	}
	
	@RequestMapping("/signUpForm")
	public String signUpFormPage() {

		return "signUpForm";
	}
	
	@RequestMapping("/signUp")
	public String signUp(HttpServletRequest request, Model model) {
		String idCheck = "";
		String passwordCheck = "";
		String nameCheck = "";
		String phoneNumberCheck = "";
		String addressCheck = "";
		String registerNumberCheck = "";
		String genderCheck = "";
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phone") + "-" + request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String registerNumber = request.getParameter("registerNumber");
		String gender = request.getParameter("gender");
		
		if(id.isBlank()) {
			idCheck = "아이디를 입력해 주세요.";
			model.addAttribute("idCheck", idCheck);
			return "signUpForm";
		}else if(password.isBlank()){
			passwordCheck = "비밀번호를 입력해 주세요";
			model.addAttribute("passwordCheck", passwordCheck);
			return "signUpForm";
		}else if(name.isBlank()) {
			nameCheck = "이름을 입력해 주세요.";
			model.addAttribute("nameCheck", nameCheck);
			return "signUpForm";
		}else if(phoneNumber.isBlank()) {
			phoneNumberCheck = "번호를 입력해 주세요";
			model.addAttribute("phoneNumberCheck", phoneNumberCheck);
			return "signUpForm";
		}else if(gender == null) {
			genderCheck = "성별을 입력해 주세요";
			model.addAttribute("genderCheck", genderCheck);
			return "signUpForm";
		}else if(address.isBlank()) {
			addressCheck = "주소를 입력해 주세요";
			model.addAttribute("addressCheck", addressCheck);
			return "signUpForm";
		}else if(registerNumber.isBlank()) {
			registerNumberCheck = "주민등록번호를 입력해 주세요";
			model.addAttribute("registerNumberCheck", registerNumberCheck);
			return "signUpForm";
		}else if(!confirmPassword.equals(password)) {
			passwordCheck = "비밀번호가 일치하지 않습니다.";
			model.addAttribute("passwordCheck", passwordCheck);
			return "signUpForm";
		}
		
		List<MemberDto> idList = dao.selectID();
		
		int checkNum = 0;
		
		for(MemberDto list : idList) {
			if((list.getId()).equals(id)) {
				break;
			}else {
				checkNum += 1;
			}
		}
		
		if(checkNum != idList.size()) {
			idCheck = "사용중인 아이디입니다.";
			model.addAttribute("idCheck", idCheck);
			return "signUpForm";
		}
		
		dao.insertMemberInfo(id, password, name, phoneNumber, address, registerNumber, gender);
		return "signUpSuccess";
	}
	
	@RequestMapping("/loginForm")
	public String loginFormPage() {
		
		return "loginForm";
	}
	
	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		session.removeAttribute("id");
		session.removeAttribute("title");
		session.removeAttribute("content");
		session.removeAttribute("titleId");
		return "homeCheckLog";
	}
	
	@RequestMapping("/joinSuccess")
	public String login(HttpSession session, HttpServletRequest request, Model model) {
		String id = request.getParameter("memberId");
		String password = request.getParameter("memberPw");
		
		String idCheck = "";
		String passwordCheck = "";
		
		List<MemberDto> idList = dao.selectID();
	
		int checkNum = 0;
		
		for(MemberDto list : idList) {
			if((list.getId()).equals(id)) {
				break;
			}else {
				++checkNum;	
			}
		}
		
		if(checkNum == idList.size()) {
			idCheck = "존재하지 않는 아이디입니다.";
			model.addAttribute("idCheck", idCheck);
			return "loginForm";
		}
		
		String passwordDB = dao.selectPassword(id);
		
		if(!passwordDB.equals(password)) {
			passwordCheck = "비밀번호가 아이디와 일치하지 않습니다.";
			model.addAttribute("passwordCheck", passwordCheck);
			return "loginForm";
		}
		
		session.setAttribute("id", id);
		
		return "home";
	}


	@RequestMapping("/signUpSuccess")
	public String signUpSuccessPage() {

		return "signUpSuccess";
	}
	
	
	@RequestMapping("/noticeBoard")
	public String listPage(HttpServletRequest request, Model model) {
		int pageCount = dao.selectAndCount();
		int totalPageNumber = (pageCount - 1) / 5 + 1;
		int page = Integer.parseInt(request.getParameter("page"));
		int backPage = page - 1;
		int forwardPage = page + 1;
		
		if(page == 1) {
			backPage = 1;
		}else if(page == totalPageNumber) {
			forwardPage = totalPageNumber;
		}
		
		model.addAttribute("list", dao.selectListDao(page));
		model.addAttribute("totalPageNumber", totalPageNumber);
		model.addAttribute("backPage", backPage);
		model.addAttribute("forwardPage", forwardPage);
		
		return "noticeBoard";
	}
	

	@RequestMapping("/writeForm")
	public String writeForm(Model model) {

		return "writeForm";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, HttpSession session) {
		
		String id = (String) session.getAttribute("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String privacy = request.getParameter("privacy");
		String password = request.getParameter("password");
		
		dao.writeDao(id, title, content, privacy, password);

		return "redirect:noticeBoard?page=1";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		dao.deleteDao(request.getParameter("titleId"));
		return "redirect:noticeBoard?page=1";
	}
	
	@RequestMapping("/passwordCheck")
	public String passwordCheck(HttpServletRequest request, HttpSession session, Model model) {
		int titleId = Integer.parseInt(request.getParameter("titleId"));
		String id = (String) session.getAttribute("id");
		String privacy = dao.selectPrivacy(titleId);
		
		String title = dao.selectTitle(titleId);
		String content = dao.selectContent(titleId);
		
		session.setAttribute("title", title);
		session.setAttribute("content", content);
		session.setAttribute("titleId", titleId);
		
		model.addAttribute("title", title);
		model.addAttribute("content", content);
		model.addAttribute("commentlist", dao.selectCommentList(titleId));
		
		if(privacy.equals("open")) {			
			
			return "commentBoard";
		}
		
		return "passwordConfirm";
	}
	
	
	
	@RequestMapping("/passwordConfirm")
	public String passwordConfirmPage() {
		
		
		return "passwordConfirm";
	}
	
	@RequestMapping("/commentPasswordConfirm")
	public String commentPasswordConfirm(HttpServletRequest request, Model model, HttpSession session) {
		int titleId = (Integer) session.getAttribute("titleId");
		String password = request.getParameter("password");
		
		String passwordCheck = "";
		
		if(!password.equals(dao.selectCommentPassword(titleId))) {
			passwordCheck = "패스워드가 일치하지 않습니다.";
			model.addAttribute("passwordCheck", passwordCheck);
			return "passwordConfirm";
		}
		
		model.addAttribute("title", session.getAttribute("title"));
		model.addAttribute("content", session.getAttribute("content"));
		model.addAttribute("commentlist", dao.selectCommentList(titleId));
		
		return "commentBoard";
	}
	
	@RequestMapping("/commentBoard")
	public String commentBoardPage(HttpServletRequest request, Model model, HttpSession session) {

		String flag = request.getParameter("flag");
		String commentFlag = request.getParameter("commentFlag");
		String commentShow = request.getParameter("commentShow");
		
		int titleId = (Integer)session.getAttribute("titleId");
		
		if (flag != null) {
			request.setAttribute("flag", flag);
			int commentId = Integer.parseInt(request.getParameter("rid"));
			request.setAttribute("rid", commentId);
		}
		
		if(commentFlag != null) {
			request.setAttribute("commentFlag", commentFlag);
			int commentId = Integer.parseInt(request.getParameter("inputId"));
			request.setAttribute("inputId", commentId);
			model.addAttribute("childCommentList", dao.selectChildComment(commentId));
		}
		
		if(commentShow != null) {
			request.setAttribute("commentShow", commentShow);
			int commentId = Integer.parseInt(request.getParameter("showId"));
			request.setAttribute("showId", commentId);
			model.addAttribute("childCommentList", dao.selectChildComment(commentId));
		}
		
		
		
		model.addAttribute("title", session.getAttribute("title"));
		model.addAttribute("content", session.getAttribute("content"));
		model.addAttribute("commentlist", dao.selectCommentList(titleId));
			
		return "commentBoard";
	}
	
	@RequestMapping("/updateCommentShow")
	public String updateComment(HttpSession session, HttpServletRequest request) {
		int titleId = (int) session.getAttribute("titleId");
		int commentId = Integer.parseInt(request.getParameter("commentId"));

		request.setAttribute("commentId", request.getParameter("commentId"));
		return "redirect:commentBoard?titleId=" + titleId + "&flag=u&rid=" + commentId;
	}
		
	@RequestMapping("/inputChildComment")
	public String inputChildComment(HttpSession session, HttpServletRequest request, Model model) {
		int titleId = (int) session.getAttribute("titleId");
		int commentId = Integer.parseInt(request.getParameter("commentId"));
				
		return "redirect:commentBoard?titleId=" + titleId + "&commentFlag=u&inputId=" + commentId;
	}
	
	@RequestMapping("/childCommentShow")
	public String childCommentShow(HttpSession session, HttpServletRequest request, Model model) {
		int titleId = (int) session.getAttribute("titleId");
		String id = (String) session.getAttribute("id");
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		String childComment = request.getParameter("childComment");
		
		
		dao.insertChildComment(commentId, id, childComment);
				
		return "redirect:commentBoard?titleId=" + titleId + "&commentShow=u&showId=" + commentId;
	}

	@RequestMapping("/commentUpdateDo")
	public String updateCommentDo(HttpServletRequest request, HttpSession session) {
		String comment = request.getParameter("comment");
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		int titleId = (int) session.getAttribute("titleId");
		dao.commentUpdate(comment, commentId);
		return "redirect:commentBoard";
	}

	@RequestMapping("/commentWrite")
	public String commentWrite(HttpSession session, HttpServletRequest request) {
		String comment = request.getParameter("comment");
		String id = (String) session.getAttribute("id");
		int titleId = (int) session.getAttribute("titleId");
		dao.insertComment(id, titleId, comment);
		return "redirect:commentBoard";
	}
	
	@RequestMapping("/deleteComment")
	public String deleteCommnet(HttpSession session, HttpServletRequest request) {
		int titleId = (int) session.getAttribute("titleId");
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		dao.commentDelete(commentId);
		return "redirect:commentBoard";

	}
}
