package com.bob.bobapp.api.response_object;


import com.google.gson.annotations.SerializedName;

public class RealizedGainLoss{

	@SerializedName("BackOfficeCode")
	private String backOfficeCode;

	@SerializedName("OpenDate")
	private String openDate;

	@SerializedName("Quantity")
	private double quantity;

	@SerializedName("SortOrder")
	private String sortOrder;

	@SerializedName("ShortName")
	private String shortName;

	@SerializedName("PurchasePrice")
	private String purchasePrice;

	@SerializedName("CostBasis")
	private String costBasis;

	@SerializedName("CloseDate")
	private String closeDate;

	@SerializedName("Source")
	private String source;

	@SerializedName("AccountNumber")
	private String accountNumber;

	@SerializedName("ClientName")
	private String clientName;

	@SerializedName("Proceeds")
	private String proceeds;

	@SerializedName("ShortTerm")
	private String shortTerm;

	@SerializedName("ClientCode")
	private String clientCode;

	@SerializedName("SalePrice")
	private String salePrice;

	@SerializedName("BackOfficeCodeEquity")
	private String backOfficeCodeEquity;

	@SerializedName("AssetClass")
	private String assetClass;

	@SerializedName("LongTerm")
	private String longTerm;

	public void setBackOfficeCode(String backOfficeCode){
		this.backOfficeCode = backOfficeCode;
	}

	public String getBackOfficeCode(){
		return backOfficeCode;
	}

	public void setOpenDate(String openDate){
		this.openDate = openDate;
	}

	public String getOpenDate(){
		return openDate;
	}

	public void setQuantity(double quantity){
		this.quantity = quantity;
	}

	public double getQuantity(){
		return quantity;
	}

	public void setSortOrder(String sortOrder){
		this.sortOrder = sortOrder;
	}

	public String getSortOrder(){
		return sortOrder;
	}

	public void setShortName(String shortName){
		this.shortName = shortName;
	}

	public String getShortName(){
		return shortName;
	}

	public void setPurchasePrice(String purchasePrice){
		this.purchasePrice = purchasePrice;
	}

	public String getPurchasePrice(){
		return purchasePrice;
	}

	public void setCostBasis(String costBasis){
		this.costBasis = costBasis;
	}

	public String getCostBasis(){
		return costBasis;
	}

	public void setCloseDate(String closeDate){
		this.closeDate = closeDate;
	}

	public String getCloseDate(){
		return closeDate;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setAccountNumber(String accountNumber){
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber(){
		return accountNumber;
	}

	public void setClientName(String clientName){
		this.clientName = clientName;
	}

	public String getClientName(){
		return clientName;
	}

	public void setProceeds(String proceeds){
		this.proceeds = proceeds;
	}

	public String getProceeds(){
		return proceeds;
	}

	public void setShortTerm(String shortTerm){
		this.shortTerm = shortTerm;
	}

	public String getShortTerm(){
		return shortTerm;
	}

	public void setClientCode(String clientCode){
		this.clientCode = clientCode;
	}

	public String getClientCode(){
		return clientCode;
	}

	public void setSalePrice(String salePrice){
		this.salePrice = salePrice;
	}

	public String getSalePrice(){
		return salePrice;
	}

	public void setBackOfficeCodeEquity(String backOfficeCodeEquity){
		this.backOfficeCodeEquity = backOfficeCodeEquity;
	}

	public String getBackOfficeCodeEquity(){
		return backOfficeCodeEquity;
	}

	public void setAssetClass(String assetClass){
		this.assetClass = assetClass;
	}

	public String getAssetClass(){
		return assetClass;
	}

	public void setLongTerm(String longTerm){
		this.longTerm = longTerm;
	}

	public String getLongTerm(){
		return longTerm;
	}
}