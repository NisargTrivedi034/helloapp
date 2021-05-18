package com.helloapp.security;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Init {

    private Context c;

    static {
        System.loadLibrary("native-lib");
    }

    public static native String pKeyU(String mKey);

    public Init(Context context) {
        c = context;
    }


    public String k() {
        try {
            PackageInfo pi = c.getPackageManager().getPackageInfo(c.getPackageName(), PackageManager.GET_SIGNATURES);
            byte[] certificate = pi.signatures[0].toByteArray();
            MessageDigest md;

            String hash_key = null;
            String hash_key2 = null;
            for (Signature signature : pi.signatures) {
                md = MessageDigest.getInstance("MD5");
                md.update(signature.toByteArray());
                hash_key = new String(Base64.encode(md.digest(), 0));
            }
            for (Signature signature : pi.signatures) {
                md = MessageDigest.getInstance("SHA-1");
                md.update(signature.toByteArray());
                hash_key2 = new String(Base64.encode(md.digest(), 0));
            }

            try {

                String tempkey = hash_key.trim() + hash_key2.trim();

                String mKey = tempkey.replaceAll("[^A-Za-z]", "");


//              return pKeyU(mKey);           //signed
                return "hjkkjhkjhkj";     //debug
            } catch (Exception e) {


            }

        } catch (NoSuchAlgorithmException e) {


        } catch (PackageManager.NameNotFoundException e) {


        }
        return null;
    }
}
