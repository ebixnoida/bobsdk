package com.bob.bobapp.api.response_object;

import com.google.gson.annotations.SerializedName;

public class SIPDueReportResponse{

	@SerializedName("Client_Name")
	private String clientName;

	@SerializedName("RequestId")
	private int requestId;

	@SerializedName("Amount")
	private int amount;

	@SerializedName("FolioNo")
	private String folioNo;

	@SerializedName("EndDate")
	private String endDate;

	@SerializedName("NextInstallmentDate")
	private String nextInstallmentDate;

	@SerializedName("Type")
	private String type;

	@SerializedName("Fund_Name")
	private String fundName;

	@SerializedName("SchemeCode")
	private int schemeCode;

	@SerializedName("Frequency")
	private String frequency;

	@SerializedName("To_FundName")
	private String toFundName;

	@SerializedName("DueDate")
	private String dueDate;

	@SerializedName("Order_No")
	private int orderNo;

	public void setClientName(String clientName){
		this.clientName = clientName;
	}

	public String getClientName(){
		return clientName;
	}

	public void setRequestId(int requestId){
		this.requestId = requestId;
	}

	public int getRequestId(){
		return requestId;
	}

	public void setAmount(int amount){
		this.amount = amount;
	}

	public int getAmount(){
		return amount;
	}

	public void setFolioNo(String folioNo){
		this.folioNo = folioNo;
	}

	public String getFolioNo(){
		return folioNo;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setNextInstallmentDate(String nextInstallmentDate){
		this.nextInstallmentDate = nextInstallmentDate;
	}

	public String getNextInstallmentDate(){
		return nextInstallmentDate;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setFundName(String fundName){
		this.fundName = fundName;
	}

	public String getFundName(){
		return fundName;
	}

	public void setSchemeCode(int schemeCode){
		this.schemeCode = schemeCode;
	}

	public int getSchemeCode(){
		return schemeCode;
	}

	public void setFrequency(String frequency){
		this.frequency = frequency;
	}

	public String getFrequency(){
		return frequency;
	}

	public void setToFundName(String toFundName){
		this.toFundName = toFundName;
	}

	public String getToFundName(){
		return toFundName;
	}

	public void setDueDate(String dueDate){
		this.dueDate = dueDate;
	}

	public String getDueDate(){
		return dueDate;
	}

	public void setOrderNo(int orderNo){
		this.orderNo = orderNo;
	}

	public int getOrderNo(){
		return orderNo;
	}

	@Override
 	public String toString(){
		return 
			"SIPDueReportResponse{" + 
			"client_Name = '" + clientName + '\'' + 
			",requestId = '" + requestId + '\'' + 
			",amount = '" + amount + '\'' + 
			",folioNo = '" + folioNo + '\'' + 
			",endDate = '" + endDate + '\'' + 
			",nextInstallmentDate = '" + nextInstallmentDate + '\'' + 
			",type = '" + type + '\'' + 
			",fund_Name = '" + fundName + '\'' + 
			",schemeCode = '" + schemeCode + '\'' + 
			",frequency = '" + frequency + '\'' + 
			",to_FundName = '" + toFundName + '\'' + 
			",dueDate = '" + dueDate + '\'' + 
			",order_No = '" + orderNo + '\'' + 
			"}";
		}
}