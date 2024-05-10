package com.vam.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.AttachMapper;
import com.vam.model.AttachImageVO;

@Service
public class AttachServiceImpl implements AttachService{
	@Autowired
	private AttachMapper attachMapper;
	
	
	/* �̹��� ������ ��ȯ */
	@Override
	public List<AttachImageVO> getAttachList(int bookId) {
		
	
		
		return attachMapper.getAttachList(bookId);
	}
}
