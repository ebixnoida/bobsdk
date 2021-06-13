package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class LifeInsuranceRequestBody{

	@SerializedName("clienttype")
	private String clienttype;

	@SerializedName("clientcode")
	private int clientcode;

	@SerializedName("HeadclientCode")
	private String headclientCode;

	@SerializedName("famcode")
	private int famcode;

	public void setClienttype(String clienttype){
		this.clienttype = clienttype;
	}

	public String getClienttype(){
		return clienttype;
	}

	public void setClientcode(int clientcode){
		this.clientcode = clientcode;
	}

	public int getClientcode(){
		return clientcode;
	}

	public void setHeadclientCode(String headclientCode){
		this.headclientCode = headclientCode;
	}

	public String getHeadclientCode(){
		return headclientCode;
	}

	public void setFamcode(int famcode){
		this.famcode = famcode;
	}

	public int getFamcode(){
		return famcode;
	}

	@Override
 	public String toString(){
		return 
			"LifeInsuranceRequestBody{" + 
			"clienttype = '" + clienttype + '\'' + 
			",clientcode = '" + clientcode + '\'' + 
			",headclientCode = '" + headclientCode + '\'' + 
			",famcode = '" + famcode + '\'' + 
			"}";
		}
}