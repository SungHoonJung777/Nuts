package com.vam.model;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProductVO {

	private List<AttachImageVO> imageList;
	/* 상품 id */
	private int pillId;

	/* 상품 이름 */
	private String pillName;

	/* 작가 id */
	private int companyId;

	/* 작가 이름 */
	private String companyName;

	/* 출판일 */
	private String publeYear;

	/* 출판사 */
	private String publisher;

	/* 카테고리 코드 */
	private String cateCode;

	/* 카테고리 이름 */
	private String cateName;

	/* 상품 가격 */
	private int pillPrice;

	/* 상품 재고 */
	private int pillStock;

	/* 상품 할인률(백분율) */
	private double pillDiscount;

	/* 상품 소개 */
	private String pillIntro;

	/* 상품 목차 */
	private String pillContents;

	/* 등록 날짜 */
	private Date regDate;

	/* 수정 날짜 */
	private Date updateDate;

	private String kind;
	private String useyn;
	private String bestyn;
	private Date indate;
	private String image;
}
