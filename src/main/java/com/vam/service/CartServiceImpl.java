package com.vam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.AttachMapper;
import com.vam.mapper.CartMapper;
import com.vam.model.AttachImageVO;
import com.vam.model.CartDTO;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
	
	@Autowired
	private  AttachMapper attachMapper;	

	@Override
	public int addCart(CartDTO cart) {

		// ��ٱ��� ������ üũ
		CartDTO checkCart = cartMapper.checkCart(cart);
		
		if(checkCart != null) {
			return 2;
		}
		
		// ��ٱ��� ��� & ���� �� 0��ȯ
		try {
			return cartMapper.addCart(cart);
		} catch (Exception e) {
			return 0;
		}		
		
	}

	@Override
	public List<CartDTO> getCartList(String memberId) {
		
		List<CartDTO> cart = cartMapper.getCart(memberId);
		
		for(CartDTO dto : cart) {
			
			/* ���� ���� �ʱ�ȭ */
			dto.initSaleTotal();
			
			/* �̹��� ���� ��� */
			int pillId = dto.getpillId();
			
			List<AttachImageVO> imageList = attachMapper.getAttachList(pillId);
			
			dto.setImageList(imageList);
		}
		
		return cart;
		
	}
	
	@Override
	public int modifyCount(CartDTO cart) {
		
		return cartMapper.modifyCount(cart);
	}	
	
	@Override
	public int deleteCart(int cartId) {

		return cartMapper.deleteCart(cartId);
	}	
	
	
}
