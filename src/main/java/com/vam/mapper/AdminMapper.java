package com.vam.mapper;

import java.util.List;

import com.vam.model.Criteria;
import com.vam.model.OrderDTO;

public interface AdminMapper {
	/* 주문 상품 리스트 */
	public List<OrderDTO> getOrderList(Criteria cri);	
	
	/* 주문 총 갯수 */
	public int getOrderTotal(Criteria cri);
}
