package com.vam.service;

import java.util.ArrayList;
import java.util.List;

import com.vam.model.AttachImageVO;
import com.vam.model.CateVO;
import com.vam.model.Criteria;
import com.vam.model.ProductVO;

public interface ProductService {
	public ArrayList<ProductVO> newProductList(ProductVO product);
	public ArrayList<ProductVO> bestProductList(ProductVO product);
	
	/* ��ǰ ��� */
	public void productEnroll(ProductVO product);
	
	/* ī�װ� ����Ʈ */
	public List<CateVO> cateList();
	/* ��ǰ ����Ʈ */
	public List<ProductVO> goodsGetList(Criteria cri);
	
	/* ��ǰ �� ���� */
	public int goodsGetTotal(Criteria cri);	
	
	/* ��ǰ ��ȸ ������ */
	public ProductVO goodsGetDetail(int pillId);
	/* ��ǰ ���� */
	public int goodsModify(ProductVO vo);
	/* ��ǰ ���� ���� */
	public int goodsDelete(int pillId);
	/* ���� ��ǰ �̹��� ���� ��� */
	public List<AttachImageVO> getAttachInfo(int pillId);	
	/* ��ǰ ���� */
	public ProductVO getGoodsInfo(int pillId);
	
}
