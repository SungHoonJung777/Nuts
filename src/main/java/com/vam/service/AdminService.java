package com.vam.service;

import java.util.List;

import com.vam.model.Criteria;
import com.vam.model.OrderDTO;

public interface AdminService {
	/* �ֹ� ��ǰ ����Ʈ */
	public List<OrderDTO> getOrderList(Criteria cri);
	
	/* �ֹ� �� ���� */
	public int getOrderTotal(Criteria cri);
}
