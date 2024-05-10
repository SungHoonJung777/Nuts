package com.vam.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vam.model.AttachImageVO;
import com.vam.model.ProductVO;
import com.vam.service.AttachService;
import com.vam.service.ProductService;


@Controller
public class NutsController {

	private static final Logger logger = LoggerFactory.getLogger(NutsController.class);
	
	@Autowired private ProductService productService;
	@Autowired private AttachService attachService;
	//
	@GetMapping("/main")
	public void mainPageGET(Model model,ProductVO product) {
		
		logger.info("���� ������ ����");
		model.addAttribute("bestProductList",productService.bestProductList(product));
		model.addAttribute("newProductList",productService.newProductList(product));
	}

	/* �̹��� ��� */
	@GetMapping("/display")
	public ResponseEntity<byte[]> getImage(String fileName){
		
		logger.info("getImage()........" + fileName);
		
		File file = new File("c:\\upload\\" + fileName);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-type", Files.probeContentType(file.toPath()));
			
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	/* �̹��� ���� ��ȯ */
	@GetMapping(value = "/uploadAjaxAction", produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<AttachImageVO>> getAttachList(int bookId){
		
		logger.info("getAttachList.........." + bookId);
		
		return new ResponseEntity<List<AttachImageVO>>(attachService.getAttachList(bookId), HttpStatus.OK);
		
	}
	
	/* ��ǰ �˻� 
	@GetMapping("/search")
	public String searchGoodsGET(Criteria cri, Model model) {
		
		logger.info("cri : " + cri);
		
		List<BookVO> list = bookService.getGoodsList(cri);
		logger.info("pre list : " + list);
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
			logger.info("list : " + list);
		} else {
			model.addAttribute("listcheck", "empty");
			
			return "search";
		}
		
		model.addAttribute("pageMaker", new PageDTO(cri, bookService.goodsGetTotal(cri)));
		
		String[] typeArr = cri.getType().split("");
		
		for(String s : typeArr) {
			if(s.equals("T") || s.equals("A")) {
				model.addAttribute("filter_info", bookService.getCateInfoList(cri));		
			}
		}
		
		return "search";
		
	}	*/
	
	/*��ǰ �� */
	@GetMapping("/goodsDetail/{pillId}")
	public String goodsDetailGET(@PathVariable("pillId")int pillId, Model model) {
		
		logger.info("goodsDetailGET()..........");
		
		model.addAttribute("goodsInfo", productService.getGoodsInfo(pillId));
		
		return "/goodsDetail";
	}	
	
	/* ���� ���� 
	@GetMapping("/replyEnroll/{memberId}")
	public String replyEnrollWindowGET(@PathVariable("memberId")String memberId, int bookId, Model model) {
		BookVO book = bookService.getBookIdName(bookId);
		model.addAttribute("bookInfo", book);
		model.addAttribute("memberId", memberId);
		
		return "/replyEnroll";
	}	*/
	
	/* ���� ���� �˾�â
	@GetMapping("/replyUpdate")
	public String replyUpdateWindowGET(ReplyDTO dto, Model model) {
		BookVO book = bookService.getBookIdName(dto.getBookId());
		model.addAttribute("bookInfo", book);
		model.addAttribute("replyInfo", replyService.getUpdateReply(dto.getReplyId()));
		model.addAttribute("memberId", dto.getMemberId());
		
		return "/replyUpdate";
	}	
	 */

}