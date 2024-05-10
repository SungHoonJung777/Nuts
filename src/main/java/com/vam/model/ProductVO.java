package com.vam.model;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProductVO {

	private List<AttachImageVO> imageList;
	/* ��ǰ id */
	private int pillId;

	/* ��ǰ �̸� */
	private String pillName;

	/* �۰� id */
	private int companyId;

	/* �۰� �̸� */
	private String companyName;

	/* ������ */
	private String publeYear;

	/* ���ǻ� */
	private String publisher;

	/* ī�װ� �ڵ� */
	private String cateCode;

	/* ī�װ� �̸� */
	private String cateName;

	/* ��ǰ ���� */
	private int pillPrice;

	/* ��ǰ ��� */
	private int pillStock;

	/* ��ǰ ���η�(�����) */
	private double pillDiscount;

	/* ��ǰ �Ұ� */
	private String pillIntro;

	/* ��ǰ ���� */
	private String pillContents;

	/* ��� ��¥ */
	private Date regDate;

	/* ���� ��¥ */
	private Date updateDate;

	private String kind;
	private String useyn;
	private String bestyn;
	private Date indate;
	private String image;
}
