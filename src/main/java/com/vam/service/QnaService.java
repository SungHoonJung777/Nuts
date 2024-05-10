package com.vam.service;

import java.util.ArrayList;

import com.vam.model.QnaVO;

public interface QnaService {
	ArrayList<QnaVO> listAllQna();
	
	public void updateQna(QnaVO qnaVO);
	
	public QnaVO getQna(int qseq);
	
	public void insertqna(QnaVO qnaVO);
}
