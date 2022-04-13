package com.example.vidgaze;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private ImageView VidGazeLogo; //get the id of the loading logo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*This below remove this bar at the top*/
        /*
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);
        getSupportActionBar().hide();*/

        setContentView(R.layout.activity_splash);

        VidGazeLogo = (ImageView) findViewById(R.id.VidGazeLogo); //get the id of the loading logo
        handleAnimation(VidGazeLogo);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        },2500);
    }

    public void handleAnimation(View view) {
       // ObjectAnimator animatorX = ObjectAnimator.ofFloat(view,"y",120f);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(view,View.ALPHA, 0.0f, 1.0f);
        alphaAnimation.setDuration(1200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(alphaAnimation);
        animatorSet.start();
    }


}