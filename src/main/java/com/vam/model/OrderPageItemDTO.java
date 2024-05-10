package com.vam.model;

import java.util.List;

public class OrderPageItemDTO {
	
	/* 뷰로부터 전달받을 값 */
    private int pillId;
    
    private int pillCount;
    
	/* DB로부터 꺼내올 값 */
    private String pillName;
    
    private int pillPrice;
    
    private double pillDiscount;
    
	/* 만들어 낼 값 */
    private int salePrice;
    
    private int totalPrice;
    
    private int point;
    
    private int totalPoint;
    
	/* 상품 이미지 */
	private List<AttachImageVO> imageList;	    

	public int getpillId() {
		return pillId;
	}

	public void setpillId(int pillId) {
		this.pillId = pillId;
	}

	public int getpillCount() {
		return pillCount;
	}

	public void setpillCount(int pillCount) {
		this.pillCount = pillCount;
	}

	public String getpillName() {
		return pillName;
	}

	public void setpillName(String pillName) {
		this.pillName = pillName;
	}

	public int getpillPrice() {
		return pillPrice;
	}

	public void setpillPrice(int pillPrice) {
		this.pillPrice = pillPrice;
	}

	public double getpillDiscount() {
		return pillDiscount;
	}

	public void setpillDiscount(double pillDiscount) {
		this.pillDiscount = pillDiscount;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}    

	public void initSaleTotal() {
		this.salePrice = (int) (this.pillPrice * (1-this.pillDiscount));
		this.totalPrice = this.salePrice*this.pillCount;
		this.point = (int)(Math.floor(this.salePrice*0.05));
		this.totalPoint =this.point * this.pillCount;
		
	}

	public List<AttachImageVO> getImageList() {
		return imageList;
	}

	public void setImageList(List<AttachImageVO> imageList) {
		this.imageList = imageList;
	}

	@Override
	public String toString() {
		return "OrderPageItemDTO [pillId=" + pillId + ", pillCount=" + pillCount + ", pillName=" + pillName
				+ ", pillPrice=" + pillPrice + ", pillDiscount=" + pillDiscount + ", salePrice=" + salePrice
				+ ", totalPrice=" + totalPrice + ", point=" + point + ", totalPoint=" + totalPoint + ", imageList="
				+ imageList + "]";
	}

	
    
}