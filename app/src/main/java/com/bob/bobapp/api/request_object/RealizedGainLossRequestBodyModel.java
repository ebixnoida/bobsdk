package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class RealizedGainLossRequestBodyModel{

	@SerializedName("CurrencyCode")
	private int currencyCode;

	@SerializedName("BOCode")
	private String bOCode;

	@SerializedName("IsFundware")
	private boolean isFundware;

	@SerializedName("FamCode")
	private int famCode;

	@SerializedName("UserId")
	private String userId;

	@SerializedName("ScripCode")
	private String scripCode;

	@SerializedName("SchemeCode")
	private int schemeCode;

	@SerializedName("FamClient")
	private String famClient;

	@SerializedName("FromDate")
	private String fromDate;

	@SerializedName("ToDate")
	private String toDate;

	@SerializedName("InvestType")
	private String investType;

	@SerializedName("AmountIn")
	private int amountIn;

	public void setCurrencyCode(int currencyCode){
		this.currencyCode = currencyCode;
	}

	public int getCurrencyCode(){
		return currencyCode;
	}

	public void setBOCode(String bOCode){
		this.bOCode = bOCode;
	}

	public String getBOCode(){
		return bOCode;
	}

	public void setIsFundware(boolean isFundware){
		this.isFundware = isFundware;
	}

	public boolean isIsFundware(){
		return isFundware;
	}

	public void setFamCode(int famCode){
		this.famCode = famCode;
	}

	public int getFamCode(){
		return famCode;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setScripCode(String scripCode){
		this.scripCode = scripCode;
	}

	public String getScripCode(){
		return scripCode;
	}

	public void setSchemeCode(int schemeCode){
		this.schemeCode = schemeCode;
	}

	public int getSchemeCode(){
		return schemeCode;
	}

	public void setFamClient(String famClient){
		this.famClient = famClient;
	}

	public String getFamClient(){
		return famClient;
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

	public void setInvestType(String investType){
		this.investType = investType;
	}

	public String getInvestType(){
		return investType;
	}

	public void setAmountIn(int amountIn){
		this.amountIn = amountIn;
	}

	public int getAmountIn(){
		return amountIn;
	}

	@Override
 	public String toString(){
		return 
			"RealizedGainLossRequestBodyModel{" + 
			"currencyCode = '" + currencyCode + '\'' + 
			",bOCode = '" + bOCode + '\'' + 
			",isFundware = '" + isFundware + '\'' + 
			",famCode = '" + famCode + '\'' + 
			",userId = '" + userId + '\'' + 
			",scripCode = '" + scripCode + '\'' + 
			",schemeCode = '" + schemeCode + '\'' + 
			",famClient = '" + famClient + '\'' + 
			",fromDate = '" + fromDate + '\'' + 
			",toDate = '" + toDate + '\'' + 
			",investType = '" + investType + '\'' + 
			",amountIn = '" + amountIn + '\'' + 
			"}";
		}
}