package com.bob.bobapp.api.response_object;

import com.google.gson.annotations.SerializedName;

public class TransactionResponseModel{

	private String Exchange;

	private String ClientName;

	private String TransactionType;

	private double TransactionRate;

	private double Amount;

	private String ClientCode;

	private double Quantity;

	private String Security;

	private String FinancialAdvisorName;

	private String Date;

	private String AccountName;

	private String AssetType;

	private String Source;

	private String ShortName;

	private String ContactDate;

	private String BrokName;

	private String SalesProceeds;

	private String CostOfOtherBasis;

	private String LongTerm;

	private String ShortTerm;

	private String CloseDate;

	private String Title;

	private String SortOrder;

	private String FolioNumber;

	private String CLUnit;

	private String CLAmount;

	private String SortOrderActual;

	private String ISIN;

	public String getExchange() {
		return Exchange;
	}

	public void setExchange(String exchange) {
		Exchange = exchange;
	}

	public String getClientName() {
		return ClientName;
	}

	public void setClientName(String clientName) {
		ClientName = clientName;
	}

	public String getTransactionType() {
		return TransactionType;
	}

	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}

	public double getTransactionRate() {
		return TransactionRate;
	}

	public void setTransactionRate(double transactionRate) {
		TransactionRate = transactionRate;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public String getClientCode() {
		return ClientCode;
	}

	public void setClientCode(String clientCode) {
		ClientCode = clientCode;
	}

	public double getQuantity() {
		return Quantity;
	}

	public void setQuantity(double quantity) {
		Quantity = quantity;
	}

	public String getSecurity() {
		return Security;
	}

	public void setSecurity(String security) {
		Security = security;
	}

	public String getFinancialAdvisorName() {
		return FinancialAdvisorName;
	}

	public void setFinancialAdvisorName(String financialAdvisorName) {
		FinancialAdvisorName = financialAdvisorName;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public String getAssetType() {
		return AssetType;
	}

	public void setAssetType(String assetType) {
		AssetType = assetType;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getShortName() {
		return ShortName;
	}

	public void setShortName(String shortName) {
		ShortName = shortName;
	}

	public String getContactDate() {
		return ContactDate;
	}

	public void setContactDate(String contactDate) {
		ContactDate = contactDate;
	}

	public String getBrokName() {
		return BrokName;
	}

	public void setBrokName(String brokName) {
		BrokName = brokName;
	}

	public String getSalesProceeds() {
		return SalesProceeds;
	}

	public void setSalesProceeds(String salesProceeds) {
		SalesProceeds = salesProceeds;
	}

	public String getCostOfOtherBasis() {
		return CostOfOtherBasis;
	}

	public void setCostOfOtherBasis(String costOfOtherBasis) {
		CostOfOtherBasis = costOfOtherBasis;
	}

	public String getLongTerm() {
		return LongTerm;
	}

	public void setLongTerm(String longTerm) {
		LongTerm = longTerm;
	}

	public String getShortTerm() {
		return ShortTerm;
	}

	public void setShortTerm(String shortTerm) {
		ShortTerm = shortTerm;
	}

	public String getCloseDate() {
		return CloseDate;
	}

	public void setCloseDate(String closeDate) {
		CloseDate = closeDate;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getSortOrder() {
		return SortOrder;
	}

	public void setSortOrder(String sortOrder) {
		SortOrder = sortOrder;
	}

	public String getFolioNumber() {
		return FolioNumber;
	}

	public void setFolioNumber(String folioNumber) {
		FolioNumber = folioNumber;
	}

	public String getCLUnit() {
		return CLUnit;
	}

	public void setCLUnit(String CLUnit) {
		this.CLUnit = CLUnit;
	}

	public String getCLAmount() {
		return CLAmount;
	}

	public void setCLAmount(String CLAmount) {
		this.CLAmount = CLAmount;
	}

	public String getSortOrderActual() {
		return SortOrderActual;
	}

	public void setSortOrderActual(String sortOrderActual) {
		SortOrderActual = sortOrderActual;
	}

	public String getISIN() {
		return ISIN;
	}

	public void setISIN(String ISIN) {
		this.ISIN = ISIN;
	}
}