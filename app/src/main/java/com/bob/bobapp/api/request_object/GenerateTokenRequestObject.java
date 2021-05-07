package com.bob.bobapp.api.request_object;

import android.content.Context;

import com.bob.bobapp.encryption.AESEncryption;
import com.google.gson.annotations.SerializedName;

import javax.crypto.SecretKey;

public class GenerateTokenRequestObject {

    private static GenerateTokenRequestObject generateTokenRequestObject = null;

    @SerializedName("UserId")
    private String UserId;

    @SerializedName("ChannelId")
    private String ChannelId;

    @SerializedName("ExtSessID")
    private String ExtSessID;

    @SerializedName("TokenId")
    private String TokenId;

    @SerializedName("Mode")
    private String Mode;

    @SerializedName("IP")
    private String ip;

    @SerializedName("Browser")
    private String Browser;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getChannelId() {
        return ChannelId;
    }

    public void setChannelId(String channelId) {
        ChannelId = channelId;
    }

    public String getExtSessID() {
        return ExtSessID;
    }

    public void setExtSessID(String extSessID) {
        ExtSessID = extSessID;
    }

    public String getTokenId() {
        return TokenId;
    }

    public void setTokenId(String tokenId) {
        TokenId = tokenId;
    }

    public String getMode() {
        return Mode;
    }

    public void setMode(String mode) {
        Mode = mode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBrowser() {
        return Browser;
    }

    public void setBrowser(String browser) {
        Browser = browser;
    }

    public static GenerateTokenRequestObject getGenerateTokenRequestObject() {

        if (generateTokenRequestObject == null) {

            generateTokenRequestObject = new GenerateTokenRequestObject();
        }

        return generateTokenRequestObject;
    }

    public static void createGenerateTokenRequestObject(String userId, String channelId, String extSessID, String tokenId, String mode, String ip, String browser, Context context) {

        try {

            userId = AESEncryption.encryptUsingKey(userId);

            channelId = AESEncryption.encryptUsingKey(channelId);

            extSessID = AESEncryption.encryptUsingKey(extSessID);

            tokenId = AESEncryption.encryptUsingKey(tokenId);

            ip = AESEncryption.encryptUsingKey(ip);

            browser = AESEncryption.encryptUsingKey(browser);

            generateTokenRequestObject = getGenerateTokenRequestObject();

            generateTokenRequestObject.setUserId(userId);

            generateTokenRequestObject.setChannelId(channelId);

            generateTokenRequestObject.setExtSessID(extSessID);

            generateTokenRequestObject.setTokenId(tokenId);

            generateTokenRequestObject.setMode(mode);

            generateTokenRequestObject.setIp(ip);

            generateTokenRequestObject.setBrowser(browser);

        }catch (Exception e){

            e.printStackTrace();
        }
    }
}
