package com.bob.bobapp.api.response_object;


import com.google.gson.annotations.SerializedName;

public class InvestmentMaturityModel{

	@SerializedName("Sch_Name")
	private String schName;

	@SerializedName("TransactionType")
	private String transactionType;

	@SerializedName("clientname")
	private String clientname;

	@SerializedName("Value_Date")
	private String valueDate;

	@SerializedName("CostOnInvestment")
	private String costOnInvestment;

	@SerializedName("Date")
	private String date;

	public void setSchName(String schName){
		this.schName = schName;
	}

	public String getSchName(){
		return schName;
	}

	public void setTransactionType(String transactionType){
		this.transactionType = transactionType;
	}

	public String getTransactionType(){
		return transactionType;
	}

	public void setClientname(String clientname){
		this.clientname = clientname;
	}

	public String getClientname(){
		return clientname;
	}

	public void setValueDate(String valueDate){
		this.valueDate = valueDate;
	}

	public String getValueDate(){
		return valueDate;
	}

	public void setCostOnInvestment(String costOnInvestment){
		this.costOnInvestment = costOnInvestment;
	}

	public String getCostOnInvestment(){
		return costOnInvestment;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	@Override
 	public String toString(){
		return 
			"InvestmentMaturityModel{" + 
			"sch_Name = '" + schName + '\'' + 
			",transactionType = '" + transactionType + '\'' + 
			",clientname = '" + clientname + '\'' + 
			",value_Date = '" + valueDate + '\'' + 
			",costOnInvestment = '" + costOnInvestment + '\'' + 
			",date = '" + date + '\'' + 
			"}";
		}
}