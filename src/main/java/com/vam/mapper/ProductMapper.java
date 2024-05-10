package com.vam.mapper;

import java.util.ArrayList;
import java.util.List;

import com.vam.model.AttachImageVO;
import com.vam.model.CateVO;
import com.vam.model.Criteria;
import com.vam.model.ProductVO;

public interface ProductMapper {
	public ArrayList<ProductVO> newProductList(ProductVO product);
	public ArrayList<ProductVO> bestProductList(ProductVO product);
	
	/* ��ǰ ��� */
	public void productEnroll(ProductVO product);
	/* ��ǰ ����Ʈ */
	public List<ProductVO> goodsGetList(Criteria cri);
	
	/* ��ǰ �� ���� */
	public int goodsGetTotal(Criteria cri);
	
	/* ī�װ� ����Ʈ */
	public List<CateVO> cateList();
	/* ��ǰ ��ȸ ������ */
	public ProductVO goodsGetDetail(int pillId);
	/* ��ǰ ���� */
	public int goodsModify(ProductVO vo);	
	
	/* ��ǰ ���� ���� */
	public int goodsDelete(int pillId);
	/* �̹��� ��� */
	public void imageEnroll(AttachImageVO vo);
	/* ���� ��ǰ �̹��� ��ü ���� */
	public void deleteImageAll(int pillId);
	/* ������ ��¥ �̹��� ����Ʈ */
	public List<AttachImageVO> checkFileList();
	/* ���� ��ǰ �̹��� ���� ��� */
	public List<AttachImageVO> getAttachInfo(int pillId);
	/* ��ǰ ���� */
	public ProductVO getGoodsInfo(int pillId);
	
}
