package com.bob.bobapp.activities;

import android.content.Context;
import android.content.Intent;

public class BOBIntent  extends Intent {

    private static final String ARG_USERNAME = "arg_username";

    private static final String ARG_DCODE = "arg_dcode";

    private static final String ARG_TRANSACTION_ID = "arg_transaction_id";

    private static final String ARG_PASSWORD = "arg_password";

    private static final String ARG_SOURCEID= "agr_dourceid";
    private static final String ARG_AGENTCODE= "agr_agentcode";
    private static final String ARG_CHECKSUM= "agr_checksum";
    private static final String ARG_ORDERID= "agr_orderid";



    public BOBIntent(Context ctx) {

        super(ctx, BOBActivity.class);
    }

    public BOBIntent(Intent intent) {

        super(intent);
    }



    public void setData(String userName, String dcode, String transactionId, String password,
                        String sourceid,String agentcode,String orderId) {

        putExtra(ARG_USERNAME, userName);

        putExtra(ARG_DCODE, dcode);

        putExtra(ARG_TRANSACTION_ID, transactionId);

        putExtra(ARG_PASSWORD, password);

        putExtra(ARG_SOURCEID, sourceid);
        putExtra(ARG_AGENTCODE, agentcode);
        putExtra(ARG_ORDERID, orderId);
    }

    public String getUsername() {

        return getStringExtra(ARG_USERNAME);
    }

    public String getDcode() {

        return getStringExtra(ARG_DCODE);
    }

    public  String getArgTransactionId() {
        return getStringExtra(ARG_TRANSACTION_ID);
    }

    public  String getArgPassword() {
        return getStringExtra(ARG_PASSWORD);
    }

    public  String getArgSourceid() {
        return getStringExtra(ARG_SOURCEID);
    }

    public  String getArgAgentcode() {
        return getStringExtra(ARG_AGENTCODE);
    }


    public  String getArgOrderid() {
        return getStringExtra(ARG_ORDERID);
    }

}