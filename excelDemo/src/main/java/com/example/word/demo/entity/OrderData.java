package com.example.word.demo.entity;

import com.deepoove.poi.data.MiniTableRenderData;

public class OrderData {

	private String storeNo;
	private String storeArea;
	private String stroreName;
	private MiniTableRenderData orderList;
	public String getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}
	public String getStoreArea() {
		return storeArea;
	}
	public void setStoreArea(String storeArea) {
		this.storeArea = storeArea;
	}
	public String getStroreName() {
		return stroreName;
	}
	public void setStroreName(String stroreName) {
		this.stroreName = stroreName;
	}
	public MiniTableRenderData getOrderList() {
		return orderList;
	}
	public void setOrderList(MiniTableRenderData orderList) {
		this.orderList = orderList;
	}
	
	
}
