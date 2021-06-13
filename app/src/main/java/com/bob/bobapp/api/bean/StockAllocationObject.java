package com.bob.bobapp.api.bean;

public class StockAllocationObject {

    private String Company;

    private String CompPercAllocation;

    private String Type;

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getCompPercAllocation() {
        return CompPercAllocation;
    }

    public void setCompPercAllocation(String compPercAllocation) {
        CompPercAllocation = compPercAllocation;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
