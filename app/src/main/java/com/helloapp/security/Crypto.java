package com.helloapp.security;

import android.content.Context;
import android.util.Base64;


import com.orhanobut.logger.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class Crypto {

    public static native String key();

    public static String
    Decrypt(String text, Context context) throws Exception {

        String key = getOriginalURL(key(), context);


        Cipher cipher = Cipher.getInstance
                ("AES/CBC/PKCS5Padding"); //this parameters should not be changed
        byte[] keyBytes = new byte[16];
        byte[] b = key.getBytes("UTF-8");
        int len = b.length;
        if (len > keyBytes.length)
            len = keyBytes.length;
        System.arraycopy(b, 0, keyBytes, 0, len);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        byte[] results = new byte[text.length()];
        try {
            results = cipher.doFinal(Base64.decode(text, Base64.NO_WRAP));
        } catch (Exception e) {
        }

        //if(BuildConfig.DEBUG){

        Logger.e(new String(results, "UTF-8"));
           /* final android.content.ClipboardManager clipboardManager = (ClipboardManager)context.getSystemService(CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("Source Text", new String(results, "UTF-8"));
            clipboardManager.setPrimaryClip(clipData);*/
        //}

        return new String(results, "UTF-8"); // it returns the result as a String
    }

    public static String Encrypt(String text, Context context) throws Exception {
        String key = getOriginalURL(key(), context);
        //if(BuildConfig.DEBUG){
            Logger.e("Request:\n"+text);
        //}
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] keyBytes = new byte[16];
        byte[] b = key.getBytes("UTF-8");
        int len = b.length;
        if (len > keyBytes.length)
            len = keyBytes.length;
        System.arraycopy(b, 0, keyBytes, 0, len);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
        return Base64.encodeToString(results, Base64.NO_WRAP); // it returns the result as a String
    }

    public static String getOriginalURL(String url, Context c) {
        String originalUrl = null;

        try {
            Init ik = new Init(c);
            originalUrl = AESHelper.decrypt(ik.k(), url);

        } catch (Exception e) {

        }

        return originalUrl;
    }
}

