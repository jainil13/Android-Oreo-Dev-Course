package com.example.timers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CountDownTimer counter = new CountDownTimer(10000, 1000)
        {
            public void onTick(long millisecondsUntilDone)
            {
                Log.i("Seconds left: ", String.valueOf(millisecondsUntilDone));
            }
            public void onFinish()
            {
                Log.i("We're done here.", "No more countdown.");
            }
        };
        counter.start();

    /*
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Hey it's us.", "A second has passed by.");
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(run);
    */
    }
}