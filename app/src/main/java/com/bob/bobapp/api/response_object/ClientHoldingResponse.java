package com.bob.bobapp.api.response_object;

import com.bob.bobapp.api.bean.ClientHoldingObject;

import java.util.ArrayList;

public class ClientHoldingResponse {

    private ArrayList<ClientHoldingObject> clientHoldingObjectArrayList;

    public ArrayList<ClientHoldingObject> getClientHoldingObjectArrayList() {
        return clientHoldingObjectArrayList;
    }

    public void setClientHoldingObjectArrayList(ArrayList<ClientHoldingObject> clientHoldingObjectArrayList) {
        this.clientHoldingObjectArrayList = clientHoldingObjectArrayList;
    }
}
