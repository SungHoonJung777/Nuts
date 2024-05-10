package com.vam.mapper;

import java.util.List;


import com.vam.model.MemberVO;
import com.vam.model.OrderDTO;
import com.vam.model.OrderItemDTO;
import com.vam.model.OrderPageItemDTO;
import com.vam.model.ProductVO;

public interface OrderMapper {

	/* �ֹ� ��ǰ ����(�ֹ� ������) */	
	public OrderPageItemDTO getGoodsInfo(int pillId);	
	
	/* �ֹ� ��ǰ ����(�ֹ� ó��) */	
	public OrderItemDTO getOrderInfo(int pillId);
	
	/* �ֹ� ���̺� ��� */
	public int enrollOrder(OrderDTO ord);	

	/* �ֹ� ������ ���̺� ��� */
	public int enrollOrderItem(OrderItemDTO orid);
	
	/* �ֹ� �ݾ� ���� */
	public int deductMoney(MemberVO member);	
	
	/* �ֹ� ��� ���� */
	public int deductStock(ProductVO pill);	
	
	/* �ֹ� ��� */
	public int orderCancle(String orderId);
	
	/* �ֹ� ��ǰ ����(�ֹ����) */
	public List<OrderItemDTO> getOrderItemInfo(String orderId);
	
	/* �ֹ� ����(�ֹ����) */
	public OrderDTO getOrder(String orderId);
	
	
}