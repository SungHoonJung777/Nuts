package com.vam.model;

import lombok.Data;

@Data
public class CateVO {
	/* ī�װ� ��� */
	private int tier;
	
	/* ī�װ� �̸� */
	private String cateName;
	
	/* ī�װ� �ѹ� */
	private String cateCode;
	
	/* ���� ī�װ� */
	private String cateParent;
}
