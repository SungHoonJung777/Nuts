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
	
	/* 상품 등록 */
	public void productEnroll(ProductVO product);
	/* 상품 리스트 */
	public List<ProductVO> goodsGetList(Criteria cri);
	
	/* 상품 총 개수 */
	public int goodsGetTotal(Criteria cri);
	
	/* 카테고리 리스트 */
	public List<CateVO> cateList();
	/* 상품 조회 페이지 */
	public ProductVO goodsGetDetail(int pillId);
	/* 상품 수정 */
	public int goodsModify(ProductVO vo);	
	
	/* 상품 정보 삭제 */
	public int goodsDelete(int pillId);
	/* 이미지 등록 */
	public void imageEnroll(AttachImageVO vo);
	/* 지정 상품 이미지 전체 삭제 */
	public void deleteImageAll(int pillId);
	/* 어제자 날짜 이미지 리스트 */
	public List<AttachImageVO> checkFileList();
	/* 지정 상품 이미지 정보 얻기 */
	public List<AttachImageVO> getAttachInfo(int pillId);
	/* 상품 정보 */
	public ProductVO getGoodsInfo(int pillId);
	
}
