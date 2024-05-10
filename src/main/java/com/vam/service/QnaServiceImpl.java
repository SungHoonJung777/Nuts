package com.vam.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.QnaMapper;
import com.vam.model.QnaVO;

@Service
public class QnaServiceImpl implements QnaService{
	
	@Autowired
	private QnaMapper qnaMapper;

	@Override
	public ArrayList<QnaVO> listAllQna() {
		// TODO Auto-generated method stub
		return qnaMapper.listAllQna();
	}

	@Override
	public void updateQna(QnaVO qnaVO) {
		qnaMapper.updateQna(qnaVO);
		
	}

	@Override
	public QnaVO getQna(int qseq) {
		// TODO Auto-generated method stub
		return qnaMapper.getQna(qseq);
				
	}

	@Override
	public void insertqna(QnaVO qnaVO) {
		qnaMapper.insertqna(qnaVO);
		
	}
	
	
	
}
