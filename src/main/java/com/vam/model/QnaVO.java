package com.vam.model;

import java.util.Date;

import lombok.Data;
@Data
public class QnaVO {
	 private int qseq; 
	 private String subject; 
	 private String content;
	 private String reply;
	 
	 private String memberId; 
	 private String rep; 
	 private Date indate;
}
