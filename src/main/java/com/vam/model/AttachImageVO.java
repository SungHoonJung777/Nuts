package com.vam.model;

import lombok.Data;

@Data
public class AttachImageVO {
	/* ��� */
	private String uploadPath;
	
	/* uuid */
	private String uuid;
	
	/* ���� �̸� */
	private String fileName;
	
	/* ��ǰ id */
	private int pillId;
}
