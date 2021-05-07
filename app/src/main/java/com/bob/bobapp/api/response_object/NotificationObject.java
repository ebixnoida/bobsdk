package com.bob.bobapp.api.response_object;

public class NotificationObject {

    private String ClientCode;

    private String ClientName;

    private String DueDate;

    private String AlertDescription;

    private String AlertType;

    private String MaturityValue;

    private String TaskType;

    private String CustomerID;

    private String AccountNumber;

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String clientCode) {
        ClientCode = clientCode;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }

    public String getAlertDescription() {
        return AlertDescription;
    }

    public void setAlertDescription(String alertDescription) {
        AlertDescription = alertDescription;
    }

    public String getAlertType() {
        return AlertType;
    }

    public void setAlertType(String alertType) {
        AlertType = alertType;
    }

    public String getMaturityValue() {
        return MaturityValue;
    }

    public void setMaturityValue(String maturityValue) {
        MaturityValue = maturityValue;
    }

    public String getTaskType() {
        return TaskType;
    }

    public void setTaskType(String taskType) {
        TaskType = taskType;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }
}
