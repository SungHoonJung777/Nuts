package com.vam.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vam.model.AttachImageVO;
import com.vam.model.CompanyVO;
import com.vam.model.Criteria;
import com.vam.model.OrderCancelDTO;
import com.vam.model.OrderDTO;
import com.vam.model.PageDTO;
import com.vam.model.ProductVO;
import com.vam.service.AdminService;
import com.vam.service.AttachService;
import com.vam.service.CompanyService;
import com.vam.service.OrderService;
import com.vam.service.ProductService;

import net.coobird.thumbnailator.Thumbnails;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	/*
	 * 
	 * 
	 * 
	 * 
	 * @Autowired private OrderService orderService;
	 */

	@Autowired
	private CompanyService companyService;

	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private AttachService attachService;

	/* 관리자 메인 페이지 이동 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public void adminMainGET() throws Exception {

		logger.info("관리자 페이지 이동");

	}

	/* 상품 관리(상품목록) 페이지 접속 */

	@RequestMapping(value = "goodsManage", method = RequestMethod.GET)
	public void goodsManageGET(Criteria cri, Model model) throws Exception {

		logger.info("상품 관리(상품목록) 페이지 접속");

		List list = productService.goodsGetList(cri);

		if (!list.isEmpty()) {
			model.addAttribute("list", list);
		} else {
			model.addAttribute("listCheck", "empty");
			return;
		}

		model.addAttribute("pageMaker", new PageDTO(cri, productService.goodsGetTotal(cri)));

	}

	/* 상품 등록 페이지 접속 */

	@RequestMapping(value = "goodsEnroll", method = RequestMethod.GET)
	public void goodsEnrollGET(Model model) throws Exception {

		logger.info("상품 등록 페이지 접속");

		ObjectMapper objm = new ObjectMapper();

		List list = productService.cateList();

		String cateList = objm.writeValueAsString(list);

		model.addAttribute("cateList", cateList);

		logger.info("변경 전.........." + list);
		logger.info("변경 gn.........." + cateList);

	}

	@PostMapping("/goodsEnroll")
	public String goodsEnrollPOST(ProductVO product, RedirectAttributes rttr) {

		logger.info("goodsEnrollPOST......" + product);

		productService.productEnroll(product);

		rttr.addFlashAttribute("enroll_result", product.getPillName());

		return "redirect:/admin/goodsManage";
	}

	/* 상품 조회 페이지, 상품 수정 페이지 */

	@GetMapping({ "/goodsDetail", "/goodsModify" })
	public void goodsGetInfoGET(int pillId, Criteria cri, Model model) throws JsonProcessingException {

		logger.info("goodsGetInfo()........." + pillId);

		ObjectMapper mapper = new ObjectMapper();

		model.addAttribute("cateList", mapper.writeValueAsString(productService.cateList()));

		model.addAttribute("cri", cri);

		model.addAttribute("goodsInfo", productService.goodsGetDetail(pillId));

	}

	/* 상품 정보 수정 */

	@PostMapping("/goodsModify")
	public String goodsModifyPOST(ProductVO vo, RedirectAttributes rttr) {

		logger.info("goodsModifyPOST.........." + vo);

		int result = productService.goodsModify(vo);

		rttr.addFlashAttribute("modify_result", result);

		return "redirect:/admin/goodsManage";

	}

	/* 상품 정보 삭제 */
	@PostMapping("/goodsDelete")
	public String goodsDeletePOST(int pillId, RedirectAttributes rttr) {

		logger.info("goodsDeletePOST..........");

		List<AttachImageVO> fileList = productService.getAttachInfo(pillId);

		if (fileList != null) {

			List<Path> pathList = new ArrayList();

			fileList.forEach(vo -> {

				// 원본 이미지
				Path path = Paths.get("C:\\upload", vo.getUploadPath(), vo.getUuid() + "_" + vo.getFileName());
				pathList.add(path);

				// 섬네일 이미지
				path = Paths.get("C:\\upload", vo.getUploadPath(), "s_" + vo.getUuid() + "_" + vo.getFileName());
				pathList.add(path);

			});

			pathList.forEach(path -> {
				path.toFile().delete();
			});

		}

		int result = productService.goodsDelete(pillId);

		rttr.addFlashAttribute("delete_result", result);

		return "redirect:/admin/goodsManage";

	}

	/* 회사 등록 페이지 접속 */
	@RequestMapping(value = "companyEnroll", method = RequestMethod.GET)
	public void companyEnrollGET() throws Exception {
		logger.info("회사 등록 페이지 접속");
	}

	/* 회사 관리 페이지 접속 */
	@RequestMapping(value = "companyManage", method = RequestMethod.GET)
	public void companyManageGET(Criteria cri, Model model) throws Exception {

		logger.info("회사 관리 페이지 접속.........." + cri);

		/* 회사 목록 출력 데이터 */
		List list = companyService.companyGetList(cri);

		if (!list.isEmpty()) {
			model.addAttribute("list", list); // 회사 존재 경우
		} else {
			model.addAttribute("listCheck", "empty"); // 회사 존재하지 않을 경우
		}

		/* 페이지 이동 인터페이스 데이터 */
		model.addAttribute("pageMaker", new PageDTO(cri, companyService.companyGetTotal(cri)));

	}

	/* 회사 등록 */
	@RequestMapping(value = "/companyEnroll.do", method = RequestMethod.POST)
	public String companyEnrollPOST(CompanyVO company, RedirectAttributes rttr) throws Exception {

		logger.info("companyEnroll :" + company);

		companyService.companyEnroll(company); // 회사 등록 쿼리 수행

		rttr.addFlashAttribute("enroll_result", company.getCompanyName()); // 등록 성공 메시지(회사이름)

		return "redirect:/admin/companyManage";

	}

	/* 회사 상세, 수정 페이지 */
	@GetMapping({ "/companyDetail", "/companyModify" })
	public void companyGetInfoGET(int companyId, Criteria cri, Model model) throws Exception {

		logger.info("companyDetail......." + companyId);

		/* 회사 관리 페이지 정보 */
		model.addAttribute("cri", cri);

		/* 선택 회사 정보 */
		model.addAttribute("companyInfo", companyService.companyGetDetail(companyId));

	}

	/* 회사 정보 수정 */
	@PostMapping("/companyModify")
	public String companyModifyPOST(CompanyVO company, RedirectAttributes rttr) throws Exception {

		logger.info("companyModifyPOST......." + company);

		int result = companyService.companyModify(company);

		rttr.addFlashAttribute("modify_result", result);

		return "redirect:/admin/companyManage";

	}

	/* 회사 정보 삭제 */
	@PostMapping("/companyDelete")
	public String companyDeletePOST(int companyId, RedirectAttributes rttr) {

		logger.info("companyDeletePOST..........");

		int result = 0;

		try {

			result = companyService.companyDelete(companyId);

		} catch (Exception e) {

			e.printStackTrace();
			result = 2;
			rttr.addFlashAttribute("delete_result", result);

			return "redirect:/admin/companyManage";

		}

		rttr.addFlashAttribute("delete_result", result);

		return "redirect:/admin/companyManage";

	}

	/* 회사 검색 팝업창 */
	@GetMapping("/companyPop")
	public void companyPopGET(Criteria cri, Model model) throws Exception {
		logger.info("companyPopGET.......");

		cri.setAmount(5);

		List list = companyService.companyGetList(cri);

		if (!list.isEmpty()) {
			model.addAttribute("list", list);
		} else {
			model.addAttribute("listCheck", "empty");
		}

		model.addAttribute("pageMaker", new PageDTO(cri, companyService.companyGetTotal(cri)));
	}

	/* 첨부 파일 업로드 */
	@PostMapping(value = "/uploadAjaxAction", produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<AttachImageVO>> uploadAjaxActionPOST(MultipartFile[] uploadFile) {

		logger.info("uploadAjaxActionPOST..........");

		/* 이미지 파일 체크 */
		for (MultipartFile multipartFile : uploadFile) {

			File checkfile = new File(multipartFile.getOriginalFilename());
			String type = null;

			try {
				type = Files.probeContentType(checkfile.toPath());
				logger.info("MIME TYPE : " + type);
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (!type.startsWith("image")) {

				List<AttachImageVO> list = null;
				return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);

			}

		} // for

		String uploadFolder = "C:\\upload";

		/* 날짜 폴더 경로 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		String str = sdf.format(date);

		String datePath = str.replace("-", File.separator);

		/* 폴더 생성 */
		File uploadPath = new File(uploadFolder, datePath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		/* 이미저 정보 담는 객체 */
		List<AttachImageVO> list = new ArrayList();

		// 향상된 for
		for (MultipartFile multipartFile : uploadFile) {

			/* 이미지 정보 객체 */
			AttachImageVO vo = new AttachImageVO();

			/* 파일 이름 */
			String uploadFileName = multipartFile.getOriginalFilename();
			vo.setFileName(uploadFileName);
			vo.setUploadPath(datePath);

			/* uuid 적용 파일 이름 */
			String uuid = UUID.randomUUID().toString();
			vo.setUuid(uuid);

			uploadFileName = uuid + "_" + uploadFileName;

			/* 파일 위치, 파일 이름을 합친 File 객체 */
			File saveFile = new File(uploadPath, uploadFileName);

			/* 파일 저장 */
			try {

				multipartFile.transferTo(saveFile);

				/* 썸네일 생성(ImageIO) */
				/*
				 * File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);
				 * 
				 * BufferedImage bo_image = ImageIO.read(saveFile);
				 * 
				 * //비율 double ratio = 3; //넓이 높이 int width = (int) (bo_image.getWidth() /
				 * ratio); int height = (int) (bo_image.getHeight() / ratio);
				 * 
				 * BufferedImage bt_image = new BufferedImage(width, height,
				 * BufferedImage.TYPE_3BYTE_BGR);
				 * 
				 * Graphics2D graphic = bt_image.createGraphics();
				 * 
				 * graphic.drawImage(bo_image, 0, 0,width,height, null);
				 * 
				 * ImageIO.write(bt_image, "jpg", thumbnailFile);
				 */

				/* 방법 2 */
				File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);

				BufferedImage bo_image = ImageIO.read(saveFile);

				// 비율
				double ratio = 4;
				// 넓이 높이
				int width = (int) (bo_image.getWidth() / ratio);
				int height = (int) (bo_image.getHeight() / ratio);

				Thumbnails.of(saveFile).size(width, height).toFile(thumbnailFile);

			} catch (Exception e) {

				e.printStackTrace();

			}

			list.add(vo);

		} // for

		ResponseEntity<List<AttachImageVO>> result = new ResponseEntity<List<AttachImageVO>>(list, HttpStatus.OK);

		return result;
	}

	/* 이미지 파일 삭제 */
	@PostMapping("/deleteFile")
	public ResponseEntity<String> deleteFile(String fileName) {

		logger.info("deleteFile........" + fileName);

		File file = null;

		try {
			/* 썸네일 파일 삭제 */
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));

			file.delete();

			/* 원본 파일 삭제 */
			String originFileName = file.getAbsolutePath().replace("s_", "");

			logger.info("originFileName : " + originFileName);

			file = new File(originFileName);

			file.delete();

		} catch (Exception e) {

			e.printStackTrace();

			return new ResponseEntity<String>("fail", HttpStatus.NOT_IMPLEMENTED);

		} // catch

		return new ResponseEntity<String>("success", HttpStatus.OK);

	}

	/* 주문 현황 페이지 */

	@GetMapping("/orderList")
	public String orderListGET(Criteria cri, Model model) {

		List<OrderDTO> list = adminService.getOrderList(cri);

		if (!list.isEmpty()) {
			model.addAttribute("list", list);
			model.addAttribute("pageMaker", new PageDTO(cri, adminService.getOrderTotal(cri)));
		} else {
			model.addAttribute("listCheck", "empty");
		}

		return "/admin/orderList";
	}

	/* 주문삭제 */

	@PostMapping("/orderCancle")
	public String orderCanclePOST(OrderCancelDTO dto) {

		orderService.orderCancle(dto);

		return "redirect:/admin/orderList?keyword=" + dto.getKeyword() + "&amount=" + dto.getAmount() + "&pageNum="
				+ dto.getPageNum();
	}

}