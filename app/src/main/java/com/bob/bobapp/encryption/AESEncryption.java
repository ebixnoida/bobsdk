package com.bob.bobapp.encryption;
import android.content.Context;

import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.SettingPreferences;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;

import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryption {

    public static String encryptUsingKey(String value){

        String encryptedString = "";

        try {

            IvParameterSpec iv = new IvParameterSpec(Constants.AES_KEY.toString().getBytes("UTF-8"));

            SecretKeySpec skeySpec = new SecretKeySpec(Constants.AES_KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");

            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());

            encryptedString = new String(BASE64EncoderStream.encode(encrypted));

        }catch (Exception e){

            e.printStackTrace();
        }

        return encryptedString;
    }
}
