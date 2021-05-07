package com.bob.bobapp.api.request_object;


import com.google.gson.annotations.SerializedName;

public class OrderStatusRequestBody{

	@SerializedName("ClientType")
	private String clientType;

	@SerializedName("FamCode")
	private int famCode;

	@SerializedName("ClientCode")
	private int clientCode;

	@SerializedName("FromDate")
	private String fromDate;

	@SerializedName("ToDate")
	private String toDate;

	@SerializedName("HeadCode")
	private int headCode;

	public void setClientType(String clientType){
		this.clientType = clientType;
	}

	public String getClientType(){
		return clientType;
	}

	public void setFamCode(int famCode){
		this.famCode = famCode;
	}

	public int getFamCode(){
		return famCode;
	}

	public void setClientCode(int clientCode){
		this.clientCode = clientCode;
	}

	public int getClientCode(){
		return clientCode;
	}

	public void setFromDate(String fromDate){
		this.fromDate = fromDate;
	}

	public String getFromDate(){
		return fromDate;
	}

	public void setToDate(String toDate){
		this.toDate = toDate;
	}

	public String getToDate(){
		return toDate;
	}

	public void setHeadCode(int headCode){
		this.headCode = headCode;
	}

	public int getHeadCode(){
		return headCode;
	}
}