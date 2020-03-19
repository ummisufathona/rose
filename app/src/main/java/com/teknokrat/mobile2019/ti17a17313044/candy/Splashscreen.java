package com.teknokrat.mobile2019.ti17a17313044.candy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends AppCompatActivity {

    private int waktu_loading=3000;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent MainActivity = new Intent(Splashscreen.this, LoginActivity.class);
                startActivity(MainActivity);
                finish();

            }
        }, waktu_loading);


    }
}
