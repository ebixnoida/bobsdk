package com.bob.bobapp.api.response_object;

import com.google.gson.annotations.SerializedName;

public class GeneralInsuranceResponse{

	@SerializedName("Status")
	private String status;

	@SerializedName("InsuranceCompany")
	private String insuranceCompany;

	@SerializedName("Category")
	private String category;

	@SerializedName("EndorsementID")
	private int endorsementID;

	@SerializedName("Clientname")
	private String clientname;

	@SerializedName("InternalOrderID")
	private int internalOrderID;

	@SerializedName("Product")
	private String product;

	@SerializedName("Premium")
	private double premium;

	@SerializedName("suminsured")
	private double suminsured;

	@SerializedName("startdate")
	private String startdate;

	@SerializedName("Proposaldoc")
	private String proposaldoc;

	@SerializedName("Confirmationdoc")
	private String confirmationdoc;

	@SerializedName("Type")
	private String type;

	@SerializedName("enddate")
	private String enddate;

	@SerializedName("policynumber")
	private int policynumber;

	@SerializedName("PolicyName")
	private String policyName;

	@SerializedName("AccountName")
	private String accountName;

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setInsuranceCompany(String insuranceCompany){
		this.insuranceCompany = insuranceCompany;
	}

	public String getInsuranceCompany(){
		return insuranceCompany;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setEndorsementID(int endorsementID){
		this.endorsementID = endorsementID;
	}

	public int getEndorsementID(){
		return endorsementID;
	}

	public void setClientname(String clientname){
		this.clientname = clientname;
	}

	public String getClientname(){
		return clientname;
	}

	public void setInternalOrderID(int internalOrderID){
		this.internalOrderID = internalOrderID;
	}

	public int getInternalOrderID(){
		return internalOrderID;
	}

	public void setProduct(String product){
		this.product = product;
	}

	public String getProduct(){
		return product;
	}

	public void setPremium(double premium){
		this.premium = premium;
	}

	public double getPremium(){
		return premium;
	}

	public void setSuminsured(double suminsured){
		this.suminsured = suminsured;
	}

	public double getSuminsured(){
		return suminsured;
	}

	public void setStartdate(String startdate){
		this.startdate = startdate;
	}

	public String getStartdate(){
		return startdate;
	}

	public void setProposaldoc(String proposaldoc){
		this.proposaldoc = proposaldoc;
	}

	public String getProposaldoc(){
		return proposaldoc;
	}

	public void setConfirmationdoc(String confirmationdoc){
		this.confirmationdoc = confirmationdoc;
	}

	public String getConfirmationdoc(){
		return confirmationdoc;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setEnddate(String enddate){
		this.enddate = enddate;
	}

	public String getEnddate(){
		return enddate;
	}

	public void setPolicynumber(int policynumber){
		this.policynumber = policynumber;
	}

	public int getPolicynumber(){
		return policynumber;
	}

	public void setPolicyName(String policyName){
		this.policyName = policyName;
	}

	public String getPolicyName(){
		return policyName;
	}

	public void setAccountName(String accountName){
		this.accountName = accountName;
	}

	public String getAccountName(){
		return accountName;
	}
}