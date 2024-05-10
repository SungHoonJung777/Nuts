package com.vam.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vam.model.QnaVO;
import com.vam.service.QnaService;

@Controller
public class QnaController {
	@Autowired
	private QnaService qnaService;

	@GetMapping("/qnaList")
	public void QnaListGET(Model model) {

		ArrayList<QnaVO> qnaList = qnaService.listAllQna();

		model.addAttribute("qnaList", qnaList);

	}

	/*Qna »ó¼¼ */
	@GetMapping("/qnaView/{pillId}")
	public String QnaViewGET(@PathVariable("pillId")int qseq, Model model) {
		
		model.addAttribute("qnaInfo", qnaService.getQna(qseq));
		
		return "/qnaView";
	}	
	
	@GetMapping("/qnaWrite")
	public void QnaWriteGET() {
		
	}
	
	@PostMapping("/qnaWrite")
	public String QnaWriteGET(QnaVO qnaVO) {
		
		qnaService.insertqna(qnaVO);

		return "redirect:/qnaList";
	}
	
	@GetMapping("/admin/qnaList")
	public void AdminQnaListGet(Model model) {
		ArrayList<QnaVO> qnaList = qnaService.listAllQna();

		model.addAttribute("qnaList", qnaList);
	}
	@PostMapping("/admin/qnaList")
	public void AdminQnaListPost(Model model) {
		ArrayList<QnaVO> qnaList = qnaService.listAllQna();

		model.addAttribute("qnaList", qnaList);
	}
	
	@GetMapping("/admin/qnaDetail")
	public String AdminQnaListView(int qseq, Model model) {
		
		model.addAttribute("qnaVO", qnaService.getQna(qseq));
		
		return "/admin/qnaDetail";
	}
	@PostMapping("/admin/qnaRepsave")
	public String AdminQnaRepsave(int qseq,String reply,Model model) {
		QnaVO qnaVO = new QnaVO();
		qnaVO.setQseq(qseq);
		qnaVO.setReply(reply);
		
		qnaService.updateQna(qnaVO);
		return "redirect:/admin/qnaList";
		
	}
}
