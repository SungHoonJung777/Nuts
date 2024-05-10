package com.vam.mapper;

import java.util.List;

import com.vam.model.AttachImageVO;

public interface AttachMapper {
	public List<AttachImageVO> getAttachList(int bookId);
}
