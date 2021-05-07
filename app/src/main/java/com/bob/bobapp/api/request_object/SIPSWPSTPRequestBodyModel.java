package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class SIPSWPSTPRequestBodyModel{

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

	@SerializedName("Report_Type")
	private String reportType;

	@SerializedName("Ucc")
	private String Ucc;

	@SerializedName("UserId")
	private String UserId;

	public String getUcc() {
		return Ucc;
	}

	public void setUcc(String ucc) {
		Ucc = ucc;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

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

	public void setReportType(String reportType){
		this.reportType = reportType;
	}

	public String getReportType(){
		return reportType;
	}

	@Override
 	public String toString(){
		return 
			"SIPSWPSTPRequestBodyModel{" + 
			"clientType = '" + clientType + '\'' + 
			",famCode = '" + famCode + '\'' + 
			",clientCode = '" + clientCode + '\'' + 
			",fromDate = '" + fromDate + '\'' + 
			",toDate = '" + toDate + '\'' + 
			",headCode = '" + headCode + '\'' + 
			",report_Type = '" + reportType + '\'' + 
			"}";
		}
}