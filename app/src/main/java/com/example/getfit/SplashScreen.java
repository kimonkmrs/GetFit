package com.example.getfit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {
    Animation up, down;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        textView=findViewById(R.id.appname);
        imageView=findViewById(R.id.sport_icon);
        down= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        textView.setAnimation(down);
        up=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
        imageView.setAnimation(up);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();

            }
        },5000);
    }
}