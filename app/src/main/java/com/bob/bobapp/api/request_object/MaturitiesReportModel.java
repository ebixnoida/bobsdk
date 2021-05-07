package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class MaturitiesReportModel{

	@SerializedName("FromDate")
	private String fromDate;

	@SerializedName("Head_Code")
	private String headCode;

	@SerializedName("Till_Date")
	private String tillDate;

	@SerializedName("ClientType")
	private String ClientType;

	@SerializedName("IsFundware")
	private String IsFundware;

	@SerializedName("UserId")
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClientType() {
		return ClientType;
	}

	public void setClientType(String clientType) {
		ClientType = clientType;
	}

	public String getIsFundware() {
		return IsFundware;
	}

	public void setIsFundware(String isFundware) {
		IsFundware = isFundware;
	}

	public void setFromDate(String fromDate){
		this.fromDate = fromDate;
	}

	public String getFromDate(){
		return fromDate;
	}

	public void setHeadCode(String headCode){
		this.headCode = headCode;
	}

	public String getHeadCode(){
		return headCode;
	}

	public void setTillDate(String tillDate){
		this.tillDate = tillDate;
	}

	public String getTillDate(){
		return tillDate;
	}

	@Override
 	public String toString(){
		return 
			"MaturitiesReportModel{" + 
			"fromDate = '" + fromDate + '\'' + 
			",head_Code = '" + headCode + '\'' + 
			",till_Date = '" + tillDate + '\'' + 
			"}";
		}
}