package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class GeneralInsuranceRequestBody{

	@SerializedName("product")
	private int product;

	@SerializedName("clientType")
	private String clientType;

	@SerializedName("todate")
	private String todate;

	@SerializedName("musrid")
	private String musrid;

	@SerializedName("insurancecompid")
	private int insurancecompid;

	@SerializedName("type")
	private String type;

	@SerializedName("categoryid")
	private int categoryid;

	@SerializedName("rmcode")
	private int rmcode;

	@SerializedName("client_code")
	private int clientCode;

	@SerializedName("fromdate")
	private String fromdate;

	@SerializedName("status")
	private String status;

	public void setProduct(int product){
		this.product = product;
	}

	public int getProduct(){
		return product;
	}

	public void setClientType(String clientType){
		this.clientType = clientType;
	}

	public String getClientType(){
		return clientType;
	}

	public void setTodate(String todate){
		this.todate = todate;
	}

	public String getTodate(){
		return todate;
	}

	public void setMusrid(String musrid){
		this.musrid = musrid;
	}

	public String getMusrid(){
		return musrid;
	}

	public void setInsurancecompid(int insurancecompid){
		this.insurancecompid = insurancecompid;
	}

	public int getInsurancecompid(){
		return insurancecompid;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setCategoryid(int categoryid){
		this.categoryid = categoryid;
	}

	public int getCategoryid(){
		return categoryid;
	}

	public void setRmcode(int rmcode){
		this.rmcode = rmcode;
	}

	public int getRmcode(){
		return rmcode;
	}

	public void setClientCode(int clientCode){
		this.clientCode = clientCode;
	}

	public int getClientCode(){
		return clientCode;
	}

	public void setFromdate(String fromdate){
		this.fromdate = fromdate;
	}

	public String getFromdate(){
		return fromdate;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}