package com.vam.model;

import java.util.List;

public class CartDTO {
	
    private int cartId;
    
    private String memberId;
    
    private int pillId;
    
    private int pillCount;
    
    //pill
    
    private String pillName;
    
    private int pillPrice;
    
    private double pillDiscount;
    
    // 추가
    private int salePrice;
    
    private int totalPrice;
    
    private int point;
    
    private int totalPoint;  
    
	/* 상품 이미지 */
	private List<AttachImageVO> imageList;	    
    

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

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

	public int getTotalPrice() {
		return totalPrice;
	}	
	
	public int getPoint() {
		return point;
	}

	public int getTotalPoint() {
		return totalPoint;
	}
	
	public List<AttachImageVO> getImageList() {
		return imageList;
	}

	public void setImageList(List<AttachImageVO> imageList) {
		this.imageList = imageList;
	}	

	public void initSaleTotal() {
		this.salePrice = (int) (this.pillPrice * (1-this.pillDiscount));
		this.totalPrice = this.salePrice*this.pillCount;
		this.point = (int)(Math.floor(this.salePrice*0.05));
		this.totalPoint =this.point * this.pillCount;		
	}

	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", memberId=" + memberId + ", pillId=" + pillId + ", pillCount="
				+ pillCount + ", pillName=" + pillName + ", pillPrice=" + pillPrice + ", pillDiscount=" + pillDiscount
				+ ", salePrice=" + salePrice + ", totalPrice=" + totalPrice + ", point=" + point + ", totalPoint="
				+ totalPoint + ", imageList=" + imageList + "]";
	}

	    
	
	
    
}
