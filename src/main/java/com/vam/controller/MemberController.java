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

		

		// ȸ������ ���� ����
		memberservice.memberJoin(member);

		

		return "redirect:/main";

	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void joinGET() {


	}

	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody // �̰� ������ join.jsp�� �޼ҵ� �� ��ȯ ������
	public String memberIdChkPOST(String memberId) throws Exception {

	
		int result = memberservice.idCheck(memberId);

		

		if (result != 0) {

			return "fail"; // �ߺ� ���̵� ����

		} else {

			return "success"; // �ߺ� ���̵� x

		}

	}

	@RequestMapping(value = "/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception {

		/* ��(View)�κ��� �Ѿ�� ������ Ȯ�� */
		//logger.info("�̸��� ������ ���� Ȯ��");
		//logger.info("������ȣ : " + email);

		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;
		logger.info("������ȣ " + checkNum);

		String setFrom = "sshu777@naver.com";
		String toMail = email;
		String title = "ȸ������ ���� �̸��� �Դϴ�.";
		String content = "Ȩ�������� �湮���ּż� �����մϴ�." + "<br><br>" + "���� ��ȣ�� " + checkNum + "�Դϴ�." + "<br>"
				+ "�ش� ������ȣ�� ������ȣ Ȯ�ζ��� �����Ͽ� �ּ���.";
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

		if (lvo == null) { // ��ġ���� �ʴ� ���̵�, ��й�ȣ �Է� ���

			int result = 0;
			rttr.addFlashAttribute("result", result);
			return "redirect:/main";

		}

		session.setAttribute("member", lvo); // ��ġ�ϴ� ���̵�, ��й�ȣ ��� (�α��� ����)

		return "redirect:/main";
		/*
		 * HttpSession session = request.getSession(); String rawPw = ""; String
		 * encodePw = "";
		 * 
		 * MemberVO lvo = memberservice.memberLogin(member); // �����Ѿ��̵�� ��ġ�ϴ� ���̵� �ִ���
		 * 
		 * if(lvo != null) { // ��ġ�ϴ� ���̵� �����
		 * 
		 * rawPw = member.getMemberPw(); // ����ڰ� ������ ��й�ȣ encodePw = lvo.getMemberPw();
		 * // �����ͺ��̽��� ������ ���ڵ��� ��й�ȣ
		 * 
		 * if(true == pwEncoder.matches(rawPw, encodePw)) { // ��й�ȣ ��ġ���� �Ǵ�
		 * 
		 * lvo.setMemberPw(""); // ���ڵ��� ��й�ȣ ���� ���� session.setAttribute("member", lvo);
		 * // session�� ������� ���� ���� return "redirect:/main"; // ���������� �̵�
		 * 
		 * 
		 * } else {
		 * 
		 * rttr.addFlashAttribute("result", 0); return "redirect:/member/login"; // �α���
		 * �������� �̵�
		 * 
		 * }
		 * 
		 * } else { // ��ġ�ϴ� ���̵� �������� ���� �� (�α��� ����)
		 * 
		 * rttr.addFlashAttribute("result", 0); return "redirect:/member/login"; // �α���
		 * �������� �̵�
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
