package com.vam.service;

import java.util.List;

import com.vam.model.OrderCancelDTO;
import com.vam.model.OrderDTO;
import com.vam.model.OrderPageItemDTO;

public interface OrderService {

	/* �ֹ� ���� */
	public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders);	
	
	/* �ֹ� */
	public void  order(OrderDTO orw);	
	
	/* �ֹ� ��� */
	public void orderCancle(OrderCancelDTO dto);	
	
}