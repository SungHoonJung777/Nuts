package com.vam.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vam.model.MemberVO;
import com.vam.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberservice;

	@Autowired
	private JavaMailSender mailSender;
	/*
	 * @Autowired private BCryptPasswordEncoder pwEncoder;
	 */

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void loginGET() {
		
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPOST(MemberVO member) throws Exception {

		

		// 회원가입 서비스 실행
		memberservice.memberJoin(member);

		

		return "redirect:/main";

	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void joinGET() {


	}

	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody // 이거 없으면 join.jsp의 메소드 값 반환 안해줌
	public String memberIdChkPOST(String memberId) throws Exception {

	
		int result = memberservice.idCheck(memberId);

		

		if (result != 0) {

			return "fail"; // 중복 아이디가 존재

		} else {

			return "success"; // 중복 아이디 x

		}

	}

	@RequestMapping(value = "/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception {

		/* 뷰(View)로부터 넘어온 데이터 확인 */
		//logger.info("이메일 데이터 전송 확인");
		//logger.info("인증번호 : " + email);

		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("인증번호 " + checkNum);

		String setFrom = "sshu777@naver.com";
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 " + checkNum + "입니다." + "<br>"
				+ "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		/*
		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);

			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		String num = Integer.toString(checkNum);

		return num;
	}

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception {

		HttpSession session = request.getSession();
		MemberVO lvo = memberservice.memberLogin(member);

		if (lvo == null) { // 일치하지 않는 아이디, 비밀번호 입력 경우

			int result = 0;
			rttr.addFlashAttribute("result", result);
			return "redirect:/main";

		}

		session.setAttribute("member", lvo); // 일치하는 아이디, 비밀번호 경우 (로그인 성공)

		return "redirect:/main";
		/*
		 * HttpSession session = request.getSession(); String rawPw = ""; String
		 * encodePw = "";
		 * 
		 * MemberVO lvo = memberservice.memberLogin(member); // 제출한아이디와 일치하는 아이디 있는지
		 * 
		 * if(lvo != null) { // 일치하는 아이디 존재시
		 * 
		 * rawPw = member.getMemberPw(); // 사용자가 제출한 비밀번호 encodePw = lvo.getMemberPw();
		 * // 데이터베이스에 저장한 인코딩된 비밀번호
		 * 
		 * if(true == pwEncoder.matches(rawPw, encodePw)) { // 비밀번호 일치여부 판단
		 * 
		 * lvo.setMemberPw(""); // 인코딩된 비밀번호 정보 지움 session.setAttribute("member", lvo);
		 * // session에 사용자의 정보 저장 return "redirect:/main"; // 메인페이지 이동
		 * 
		 * 
		 * } else {
		 * 
		 * rttr.addFlashAttribute("result", 0); return "redirect:/member/login"; // 로그인
		 * 페이지로 이동
		 * 
		 * }
		 * 
		 * } else { // 일치하는 아이디가 존재하지 않을 시 (로그인 실패)
		 * 
		 * rttr.addFlashAttribute("result", 0); return "redirect:/member/login"; // 로그인
		 * 페이지로 이동
		 * 
		 * }
		 */
	}

	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String logoutMainGET(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:/main";
	}
}
