package com.beingcoderz.vpnconnector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.beingcoderz.vpnsdk.VpnKey;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VpnKey.isInitialize("api",this);

    }
}