package com.beingcoderz.vpnsdk;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class VpnKey {

    private static String FREE_SERVER = "";
    private static String PAID_SERVER = "";

    static {
        System.loadLibrary("keys");
    }

    public static native String freeURL();
    public static native String proURL();
    public static native String apiURL();

    public static void isInitialize(String Api, Context context){

        String free = new String(Base64.decode(freeURL(),Base64.DEFAULT));
        String pro = new String(Base64.decode(proURL(),Base64.DEFAULT));
        String api = new String(Base64.decode(apiURL(),Base64.DEFAULT));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    Request request = new Request.Builder().url(free+context.getPackageName()+api+Api).build();
                    Response response = okHttpClient.newCall(request).execute();
                    FREE_SERVER = response.body().string();

                    request = new Request.Builder().url(pro+context.getPackageName()+api+Api).build();
                    response = okHttpClient.newCall(request).execute();
                    PAID_SERVER = response.body().string();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String freeServer(){
        return FREE_SERVER;
    }

    public static String paidServer(){
        return PAID_SERVER;
    }
}
