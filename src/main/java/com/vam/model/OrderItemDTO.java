package com.vam.model;

public class OrderItemDTO {

	/* �ֹ� ��ȣ */
	private String orderId;
	
	/* ��ǰ ��ȣ */
    private int pillId;
    
	/* �ֹ� ���� */
    private int pillCount;
    
	/* vam_orderItem �⺻Ű */
    private int orderItemId;
    
	/* ��ǰ �� �� ���� */
    private int pillPrice;
    
	/* ��ǰ ���� �� */
    private double pillDiscount;
    
	/* ��ǰ �Ѱ� ���� �� ȹ�� ����Ʈ */
    private int savePoint;
    
	/* DB���̺� ���� ���� �ʴ� ������ */
    
	/* ���� ����� ���� */
    private int salePrice;
    
	/* �� ����(���� ����� ���� * �ֹ� ����) */
    private int totalPrice;
    
	/* �� ȹ�� ����Ʈ(��ǰ �Ѱ� ���� �� ȹ�� ����Ʈ * ����) */
    private int totalSavePoint;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
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

	public int getSavePoint() {
		return savePoint;
	}

	public void setSavePoint(int savePoint) {
		this.savePoint = savePoint;
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

	public int getTotalSavePoint() {
		return totalSavePoint;
	}

	public void setTotalSavePoint(int totalSavePoint) {
		this.totalSavePoint = totalSavePoint;
	}

	@Override
	public String toString() {
		return "OrderItemDTO [orderId=" + orderId + ", pillId=" + pillId + ", pillCount=" + pillCount + ", orderItemId="
				+ orderItemId + ", pillPrice=" + pillPrice + ", pillDiscount=" + pillDiscount + ", savePoint="
				+ savePoint + ", salePrice=" + salePrice + ", totalPrice=" + totalPrice + ", totalSavePoint="
				+ totalSavePoint + "]";
	}
	
	public void initSaleTotal() {
		this.salePrice = (int) (this.pillPrice * (1-this.pillDiscount));
		this.totalPrice = this.salePrice*this.pillCount;
		this.savePoint = (int)(Math.floor(this.salePrice*0.05));
		this.totalSavePoint =this.savePoint * this.pillCount;
	}		
    
    
	
}
