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

	/* ������ ���� ������ �̵� */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public void adminMainGET() throws Exception {

		logger.info("������ ������ �̵�");

	}

	/* ��ǰ ����(��ǰ���) ������ ���� */

	@RequestMapping(value = "goodsManage", method = RequestMethod.GET)
	public void goodsManageGET(Criteria cri, Model model) throws Exception {

		logger.info("��ǰ ����(��ǰ���) ������ ����");

		List list = productService.goodsGetList(cri);

		if (!list.isEmpty()) {
			model.addAttribute("list", list);
		} else {
			model.addAttribute("listCheck", "empty");
			return;
		}

		model.addAttribute("pageMaker", new PageDTO(cri, productService.goodsGetTotal(cri)));

	}

	/* ��ǰ ��� ������ ���� */

	@RequestMapping(value = "goodsEnroll", method = RequestMethod.GET)
	public void goodsEnrollGET(Model model) throws Exception {

		logger.info("��ǰ ��� ������ ����");

		ObjectMapper objm = new ObjectMapper();

		List list = productService.cateList();

		String cateList = objm.writeValueAsString(list);

		model.addAttribute("cateList", cateList);

		logger.info("���� ��.........." + list);
		logger.info("���� gn.........." + cateList);

	}

	@PostMapping("/goodsEnroll")
	public String goodsEnrollPOST(ProductVO product, RedirectAttributes rttr) {

		logger.info("goodsEnrollPOST......" + product);

		productService.productEnroll(product);

		rttr.addFlashAttribute("enroll_result", product.getPillName());

		return "redirect:/admin/goodsManage";
	}

	/* ��ǰ ��ȸ ������, ��ǰ ���� ������ */

	@GetMapping({ "/goodsDetail", "/goodsModify" })
	public void goodsGetInfoGET(int pillId, Criteria cri, Model model) throws JsonProcessingException {

		logger.info("goodsGetInfo()........." + pillId);

		ObjectMapper mapper = new ObjectMapper();

		model.addAttribute("cateList", mapper.writeValueAsString(productService.cateList()));

		model.addAttribute("cri", cri);

		model.addAttribute("goodsInfo", productService.goodsGetDetail(pillId));

	}

	/* ��ǰ ���� ���� */

	@PostMapping("/goodsModify")
	public String goodsModifyPOST(ProductVO vo, RedirectAttributes rttr) {

		logger.info("goodsModifyPOST.........." + vo);

		int result = productService.goodsModify(vo);

		rttr.addFlashAttribute("modify_result", result);

		return "redirect:/admin/goodsManage";

	}

	/* ��ǰ ���� ���� */
	@PostMapping("/goodsDelete")
	public String goodsDeletePOST(int pillId, RedirectAttributes rttr) {

		logger.info("goodsDeletePOST..........");

		List<AttachImageVO> fileList = productService.getAttachInfo(pillId);

		if (fileList != null) {

			List<Path> pathList = new ArrayList();

			fileList.forEach(vo -> {

				// ���� �̹���
				Path path = Paths.get("C:\\upload", vo.getUploadPath(), vo.getUuid() + "_" + vo.getFileName());
				pathList.add(path);

				// ������ �̹���
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

	/* ȸ�� ��� ������ ���� */
	@RequestMapping(value = "companyEnroll", method = RequestMethod.GET)
	public void companyEnrollGET() throws Exception {
		logger.info("ȸ�� ��� ������ ����");
	}

	/* ȸ�� ���� ������ ���� */
	@RequestMapping(value = "companyManage", method = RequestMethod.GET)
	public void companyManageGET(Criteria cri, Model model) throws Exception {

		logger.info("ȸ�� ���� ������ ����.........." + cri);

		/* ȸ�� ��� ��� ������ */
		List list = companyService.companyGetList(cri);

		if (!list.isEmpty()) {
			model.addAttribute("list", list); // ȸ�� ���� ���
		} else {
			model.addAttribute("listCheck", "empty"); // ȸ�� �������� ���� ���
		}

		/* ������ �̵� �������̽� ������ */
		model.addAttribute("pageMaker", new PageDTO(cri, companyService.companyGetTotal(cri)));

	}

	/* ȸ�� ��� */
	@RequestMapping(value = "/companyEnroll.do", method = RequestMethod.POST)
	public String companyEnrollPOST(CompanyVO company, RedirectAttributes rttr) throws Exception {

		logger.info("companyEnroll :" + company);

		companyService.companyEnroll(company); // ȸ�� ��� ���� ����

		rttr.addFlashAttribute("enroll_result", company.getCompanyName()); // ��� ���� �޽���(ȸ���̸�)

		return "redirect:/admin/companyManage";

	}

	/* ȸ�� ��, ���� ������ */
	@GetMapping({ "/companyDetail", "/companyModify" })
	public void companyGetInfoGET(int companyId, Criteria cri, Model model) throws Exception {

		logger.info("companyDetail......." + companyId);

		/* ȸ�� ���� ������ ���� */
		model.addAttribute("cri", cri);

		/* ���� ȸ�� ���� */
		model.addAttribute("companyInfo", companyService.companyGetDetail(companyId));

	}

	/* ȸ�� ���� ���� */
	@PostMapping("/companyModify")
	public String companyModifyPOST(CompanyVO company, RedirectAttributes rttr) throws Exception {

		logger.info("companyModifyPOST......." + company);

		int result = companyService.companyModify(company);

		rttr.addFlashAttribute("modify_result", result);

		return "redirect:/admin/companyManage";

	}

	/* ȸ�� ���� ���� */
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

	/* ȸ�� �˻� �˾�â */
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

	/* ÷�� ���� ���ε� */
	@PostMapping(value = "/uploadAjaxAction", produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<AttachImageVO>> uploadAjaxActionPOST(MultipartFile[] uploadFile) {

		logger.info("uploadAjaxActionPOST..........");

		/* �̹��� ���� üũ */
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

		/* ��¥ ���� ��� */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		String str = sdf.format(date);

		String datePath = str.replace("-", File.separator);

		/* ���� ���� */
		File uploadPath = new File(uploadFolder, datePath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		/* �̹��� ���� ��� ��ü */
		List<AttachImageVO> list = new ArrayList();

		// ���� for
		for (MultipartFile multipartFile : uploadFile) {

			/* �̹��� ���� ��ü */
			AttachImageVO vo = new AttachImageVO();

			/* ���� �̸� */
			String uploadFileName = multipartFile.getOriginalFilename();
			vo.setFileName(uploadFileName);
			vo.setUploadPath(datePath);

			/* uuid ���� ���� �̸� */
			String uuid = UUID.randomUUID().toString();
			vo.setUuid(uuid);

			uploadFileName = uuid + "_" + uploadFileName;

			/* ���� ��ġ, ���� �̸��� ��ģ File ��ü */
			File saveFile = new File(uploadPath, uploadFileName);

			/* ���� ���� */
			try {

				multipartFile.transferTo(saveFile);

				/* ����� ����(ImageIO) */
				/*
				 * File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);
				 * 
				 * BufferedImage bo_image = ImageIO.read(saveFile);
				 * 
				 * //���� double ratio = 3; //���� ���� int width = (int) (bo_image.getWidth() /
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

				/* ��� 2 */
				File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);

				BufferedImage bo_image = ImageIO.read(saveFile);

				// ����
				double ratio = 4;
				// ���� ����
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

	/* �̹��� ���� ���� */
	@PostMapping("/deleteFile")
	public ResponseEntity<String> deleteFile(String fileName) {

		logger.info("deleteFile........" + fileName);

		File file = null;

		try {
			/* ����� ���� ���� */
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));

			file.delete();

			/* ���� ���� ���� */
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

	/* �ֹ� ��Ȳ ������ */

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

	/* �ֹ����� */

	@PostMapping("/orderCancle")
	public String orderCanclePOST(OrderCancelDTO dto) {

		orderService.orderCancle(dto);

		return "redirect:/admin/orderList?keyword=" + dto.getKeyword() + "&amount=" + dto.getAmount() + "&pageNum="
				+ dto.getPageNum();
	}

}