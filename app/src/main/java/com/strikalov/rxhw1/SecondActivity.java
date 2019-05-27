package com.strikalov.rxhw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.strikalov.rxhw1.SecondTask.SpamObserver;
import com.strikalov.rxhw1.SecondTask.Spamer;

public class SecondActivity extends AppCompatActivity {

    private static String TAG = "MyLogger";

    private Button subscribeButton;
    private Button unsubscribeButton;
    private Button spamButton;

    private SpamObserver spamObserver;
    private Spamer spamer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        subscribeButton = findViewById(R.id.subscribe_button);
        unsubscribeButton = findViewById(R.id.unsubscribe_button);
        spamButton = findViewById(R.id.spam_button);

        spamer = new Spamer();
        spamObserver = new SpamObserver();

        subscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spamer.subscribe(spamObserver);
                Log.i(TAG, "Subscribe");
            }
        });

        unsubscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spamer.unsubscribe(spamObserver);
                Log.i(TAG, "Unsubscribe");
            }
        });

        spamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spamer.spam();
            }
        });
    }
}
