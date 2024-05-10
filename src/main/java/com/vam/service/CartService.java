package com.vam.service;

import java.util.List;

import com.vam.model.CartDTO;

public interface CartService {
	
	/* ��ٱ��� �߰� */
	public int addCart(CartDTO cart);	
	
	/* ��ٱ��� ���� ����Ʈ */
	public List<CartDTO> getCartList(String memberId);	
	
	/* īƮ ���� ���� */
	public int modifyCount(CartDTO cart);		
	
	/* īƮ ���� */
	public int deleteCart(int cartId);	

}
