package com.vam.mapper;

import java.util.ArrayList;

import com.vam.model.QnaVO;

public interface QnaMapper {
	ArrayList<QnaVO> listAllQna();
	
	public void updateQna(QnaVO qnaVO);
	
	public QnaVO getQna(int qseq);
	
	public void insertqna(QnaVO qnaVO);
	
	
}
