package com.beingcoderz.vpnsdk;

import android.content.Context;
import android.util.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class VpnKey {

    private static String FREE_SERVER = "";
    private static String PAID_SERVER = "";


    public static void isInitialize(String Api, Context context){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient okHttpClient = new OkHttpClient();
                    Request request = new Request.Builder().url(KeyUrl.FREE_URL+context.getPackageName()+KeyUrl.API_URL+Api).build();
                    Response response = okHttpClient.newCall(request).execute();
                    FREE_SERVER = response.body().string();

                    request = new Request.Builder().url(KeyUrl.PAID_URL+context.getPackageName()+KeyUrl.API_URL+Api).build();
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
