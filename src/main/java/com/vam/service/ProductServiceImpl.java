package com.vam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vam.mapper.ProductMapper;
import com.vam.model.AttachImageVO;
import com.vam.model.CateVO;
import com.vam.model.Criteria;
import com.vam.model.ProductVO;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductMapper productrMapper;

	@Override
	public ArrayList<ProductVO> newProductList(ProductVO product) {
	    return productrMapper.newProductList(product);
	}


	@Override
	public ArrayList<ProductVO> bestProductList(ProductVO product) {
		
		return productrMapper.bestProductList(product);
	}

	@Transactional
	@Override
	public void productEnroll(ProductVO product) {
		productrMapper.productEnroll(product);
		
		if(product.getImageList() == null || product.getImageList().size() <= 0) {
			return;
		}
		product.getImageList().forEach(attach ->{
			
			attach.setPillId(product.getPillId());
			productrMapper.imageEnroll(attach);
			
		});
	}
	/* ī�װ� ����Ʈ */
	@Override
	public List<CateVO> cateList() {
		
	
		
		return productrMapper.cateList();
	}
	
	
	/* ��ǰ ����Ʈ */
	@Override
	public List<ProductVO> goodsGetList(Criteria cri) {
		
		return productrMapper.goodsGetList(cri);
	}

	/* ��ǰ �� ���� */
	public int goodsGetTotal(Criteria cri) {
		
		return productrMapper.goodsGetTotal(cri);
	}	
	
	/* ��ǰ ��ȸ ������ */
	@Override
	public ProductVO goodsGetDetail(int pillId) {
		
		return productrMapper.goodsGetDetail(pillId);
	}	
	/* ��ǰ ���� ���� */
	@Transactional
	@Override
	public int goodsModify(ProductVO vo) {
		
	int result = productrMapper.goodsModify(vo);
			
			if(result == 1 && vo.getImageList() != null && vo.getImageList().size() > 0) {
				
				productrMapper.deleteImageAll(vo.getPillId());
				
				vo.getImageList().forEach(attach -> {
					
					attach.setPillId(vo.getPillId());
					productrMapper.imageEnroll(attach);
					
				});
				
			}
			
		return result;
		
	}
	/* ��ǰ ���� ���� */
	@Override
	@Transactional
	public int goodsDelete(int pillId) {

		productrMapper.deleteImageAll(pillId);			
		
		return productrMapper.goodsDelete(pillId);
	}


	@Override
	public List<AttachImageVO> getAttachInfo(int pillId) {
		return productrMapper.getAttachInfo(pillId);
	}
	

	@Override
	public ProductVO getGoodsInfo(int pillId) {
		
		ProductVO goodsInfo = productrMapper.getGoodsInfo(pillId);
		goodsInfo.setImageList(productrMapper.getAttachInfo(pillId));
		
		return goodsInfo;
	}



}
