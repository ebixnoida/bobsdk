package com.bob.bobapp.api.response_object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class OrderStatusResponse {
	@SerializedName("Client_Name")
	@Expose
	private String clientName;
	@SerializedName("Account_Name")
	@Expose
	private String accountName;
	@SerializedName("Order_No")
	@Expose
	private Long orderNo;
	@SerializedName("Folio_No")
	@Expose
	private String folioNo;
	@SerializedName("Order_Status")
	@Expose
	private String orderStatus;
	@SerializedName("Fund_Name")
	@Expose
	private String fundName;
	@SerializedName("From_Fund_Name")
	@Expose
	private String fromFundName;
	@SerializedName("Order_Type")
	@Expose
	private String orderType;
	@SerializedName("Request_No")
	@Expose
	private String requestNo;
	@SerializedName("Value_Date")
	@Expose
	private String valueDate;
	@SerializedName("Order_Date")
	@Expose
	private String orderDate;
	@SerializedName("Order_Amount")
	@Expose
	private Double orderAmount;
	@SerializedName("Order_Qty")
	@Expose
	private Double orderQty;
	@SerializedName("OrderSource")
	@Expose
	private String orderSource;
	@SerializedName("OrderBasis")
	@Expose
	private Object orderBasis;

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public String getFolioNo() {
		return folioNo;
	}

	public void setFolioNo(String folioNo) {
		this.folioNo = folioNo;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getFromFundName() {
		return fromFundName;
	}

	public void setFromFundName(String fromFundName) {
		this.fromFundName = fromFundName;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Double getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(Double orderQty) {
		this.orderQty = orderQty;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public Object getOrderBasis() {
		return orderBasis;
	}

	public void setOrderBasis(Object orderBasis) {
		this.orderBasis = orderBasis;
	}
}

