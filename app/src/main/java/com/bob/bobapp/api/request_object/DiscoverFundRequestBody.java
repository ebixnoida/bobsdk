package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class DiscoverFundRequestBody{

	@SerializedName("clientcode")
	private int clientcode;

	public void setClientcode(int clientcode){
		this.clientcode = clientcode;
	}

	public int getClientcode(){
		return clientcode;
	}
}