package com.bob.bobapp.api.response_object;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LifeInsuranceResponse implements Parcelable {

	@SerializedName("id")
	@Expose
	private Long id;
	@SerializedName("rider_id")
	@Expose
	private Long riderId;
	@SerializedName("ACNumber")
	@Expose
	private Long aCNumber;
	@SerializedName("FundValue")
	@Expose
	private Double fundValue;
	@SerializedName("BranchName")
	@Expose
	private String branchName;
	@SerializedName("Ridername")
	@Expose
	private Object ridername;
	@SerializedName("RiderAmount")
	@Expose
	private Object riderAmount;
	@SerializedName("AcType")
	@Expose
	private String acType;
	@SerializedName("AccountNumber")
	@Expose
	private Long accountNumber;
	@SerializedName("MICRCode")
	@Expose
	private Long mICRCode;
	@SerializedName("BankName")
	@Expose
	private Object bankName;
	@SerializedName("City")
	@Expose
	private String city;
	@SerializedName("ClientName")
	@Expose
	private String clientName;
	@SerializedName("client_code")
	@Expose
	private Long clientCode;
	@SerializedName("InsuranceCompany")
	@Expose
	private String insuranceCompany;
	@SerializedName("PolicyName")
	@Expose
	private String policyName;
	@SerializedName("PolicyType")
	@Expose
	private String policyType;
	@SerializedName("policyno")
	@Expose
	private String policyno;
	@SerializedName("Premiumstdate")
	@Expose
	private String premiumstdate;
	@SerializedName("Startdate")
	@Expose
	private String startdate;
	@SerializedName("policymaturitydate")
	@Expose
	private String policymaturitydate;
	@SerializedName("Frequency")
	@Expose
	private String frequency;
	@SerializedName("Amount")
	@Expose
	private Double amount;
	@SerializedName("Premiumamount")
	@Expose
	private Double premiumamount;
	@SerializedName("AnnualPremium")
	@Expose
	private Double annualPremium;
	@SerializedName("Manager_Name")
	@Expose
	private String managerName;
	@SerializedName("PolicyStatus")
	@Expose
	private Object policyStatus;
	@SerializedName("SurrenderValue")
	@Expose
	private Double surrenderValue;
	@SerializedName("duedate")
	@Expose
	private String duedate;

	protected LifeInsuranceResponse(Parcel in) {
		if (in.readByte() == 0) {
			id = null;
		} else {
			id = in.readLong();
		}
		if (in.readByte() == 0) {
			riderId = null;
		} else {
			riderId = in.readLong();
		}
		if (in.readByte() == 0) {
			aCNumber = null;
		} else {
			aCNumber = in.readLong();
		}
		if (in.readByte() == 0) {
			fundValue = null;
		} else {
			fundValue = in.readDouble();
		}
		branchName = in.readString();
		acType = in.readString();
		if (in.readByte() == 0) {
			accountNumber = null;
		} else {
			accountNumber = in.readLong();
		}
		if (in.readByte() == 0) {
			mICRCode = null;
		} else {
			mICRCode = in.readLong();
		}
		city = in.readString();
		clientName = in.readString();
		if (in.readByte() == 0) {
			clientCode = null;
		} else {
			clientCode = in.readLong();
		}
		insuranceCompany = in.readString();
		policyName = in.readString();
		policyType = in.readString();
		premiumstdate = in.readString();
		startdate = in.readString();
		policymaturitydate = in.readString();
		frequency = in.readString();
		if (in.readByte() == 0) {
			amount = null;
		} else {
			amount = in.readDouble();
		}
		if (in.readByte() == 0) {
			premiumamount = null;
		} else {
			premiumamount = in.readDouble();
		}
		if (in.readByte() == 0) {
			annualPremium = null;
		} else {
			annualPremium = in.readDouble();
		}
		managerName = in.readString();
		if (in.readByte() == 0) {
			surrenderValue = null;
		} else {
			surrenderValue = in.readDouble();
		}
		duedate = in.readString();
	}

	public static final Creator<LifeInsuranceResponse> CREATOR = new Creator<LifeInsuranceResponse>() {
		@Override
		public LifeInsuranceResponse createFromParcel(Parcel in) {
			return new LifeInsuranceResponse(in);
		}

		@Override
		public LifeInsuranceResponse[] newArray(int size) {
			return new LifeInsuranceResponse[size];
		}
	};

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRiderId() {
		return riderId;
	}

	public void setRiderId(Long riderId) {
		this.riderId = riderId;
	}

	public Long getACNumber() {
		return aCNumber;
	}

	public void setACNumber(Long aCNumber) {
		this.aCNumber = aCNumber;
	}

	public Double getFundValue() {
		return fundValue;
	}

	public void setFundValue(Double fundValue) {
		this.fundValue = fundValue;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Object getRidername() {
		return ridername;
	}

	public void setRidername(Object ridername) {
		this.ridername = ridername;
	}

	public Object getRiderAmount() {
		return riderAmount;
	}

	public void setRiderAmount(Object riderAmount) {
		this.riderAmount = riderAmount;
	}

	public String getAcType() {
		return acType;
	}

	public void setAcType(String acType) {
		this.acType = acType;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getMICRCode() {
		return mICRCode;
	}

	public void setMICRCode(Long mICRCode) {
		this.mICRCode = mICRCode;
	}

	public Object getBankName() {
		return bankName;
	}

	public void setBankName(Object bankName) {
		this.bankName = bankName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Long getClientCode() {
		return clientCode;
	}

	public void setClientCode(Long clientCode) {
		this.clientCode = clientCode;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyno() {
		return policyno;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}

	public String getPremiumstdate() {
		return premiumstdate;
	}

	public void setPremiumstdate(String premiumstdate) {
		this.premiumstdate = premiumstdate;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getPolicymaturitydate() {
		return policymaturitydate;
	}

	public void setPolicymaturitydate(String policymaturitydate) {
		this.policymaturitydate = policymaturitydate;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPremiumamount() {
		return premiumamount;
	}

	public void setPremiumamount(Double premiumamount) {
		this.premiumamount = premiumamount;
	}

	public Double getAnnualPremium() {
		return annualPremium;
	}

	public void setAnnualPremium(Double annualPremium) {
		this.annualPremium = annualPremium;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Object getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(Object policyStatus) {
		this.policyStatus = policyStatus;
	}

	public Double getSurrenderValue() {
		return surrenderValue;
	}

	public void setSurrenderValue(Double surrenderValue) {
		this.surrenderValue = surrenderValue;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		if (id == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeLong(id);
		}
		if (riderId == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeLong(riderId);
		}
		if (aCNumber == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeLong(aCNumber);
		}
		if (fundValue == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeDouble(fundValue);
		}
		parcel.writeString(branchName);
		parcel.writeString(acType);
		if (accountNumber == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeLong(accountNumber);
		}
		if (mICRCode == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeLong(mICRCode);
		}
		parcel.writeString(city);
		parcel.writeString(clientName);
		if (clientCode == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeLong(clientCode);
		}
		parcel.writeString(insuranceCompany);
		parcel.writeString(policyName);
		parcel.writeString(policyType);
		parcel.writeString(premiumstdate);
		parcel.writeString(startdate);
		parcel.writeString(policymaturitydate);
		parcel.writeString(frequency);
		if (amount == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeDouble(amount);
		}
		if (premiumamount == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeDouble(premiumamount);
		}
		if (annualPremium == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeDouble(annualPremium);
		}
		parcel.writeString(managerName);
		if (surrenderValue == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeDouble(surrenderValue);
		}
		parcel.writeString(duedate);
	}
}