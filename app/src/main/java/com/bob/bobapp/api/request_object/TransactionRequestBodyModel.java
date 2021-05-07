package com.bob.bobapp.api.request_object;

import com.google.gson.annotations.SerializedName;

public class TransactionRequestBodyModel  {

	@SerializedName("CurrencyCode")
	private String currencyCode;

	@SerializedName("OnlineAccountCode")
	private String onlineAccountCode;

	@SerializedName("AccountLevel")
	private String accountLevel;

	@SerializedName("OrderType")
	private String orderType;

	@SerializedName("PageSize")
	private String pageSize;

	@SerializedName("UserId")
	private String userId;

	@SerializedName("SchemeCode")
	private String schemeCode;

	@SerializedName("DateFrom")
	private String dateFrom;

	@SerializedName("PageIndex")
	private String pageIndex;

	@SerializedName("AmountDenomination")
	private String amountDenomination;

	@SerializedName("DateTo")
	private String dateTo;


    @SerializedName("ClientType")
    private String ClientType;

    @SerializedName("IsFundware")
    private String IsFundware;


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

    public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getOnlineAccountCode() {
		return onlineAccountCode;
	}

	public void setOnlineAccountCode(String onlineAccountCode) {
		this.onlineAccountCode = onlineAccountCode;
	}

	public String getAccountLevel() {
		return accountLevel;
	}

	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getAmountDenomination() {
		return amountDenomination;
	}

	public void setAmountDenomination(String amountDenomination) {
		this.amountDenomination = amountDenomination;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
}