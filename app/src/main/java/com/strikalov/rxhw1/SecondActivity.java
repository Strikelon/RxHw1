package com.strikalov.rxhw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button subscribeButton;
    private Button unsubscribeButton;
    private Button spamButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        subscribeButton = findViewById(R.id.subscribe_button);
        unsubscribeButton = findViewById(R.id.unsubscribe_button);
        spamButton = findViewById(R.id.spam_button);
    }
}
