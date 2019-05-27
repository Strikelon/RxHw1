package com.strikalov.rxhw1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

public class FirstActivity extends AppCompatActivity {

    private static String TAG = "MyLogger";

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        startButton = findViewById(R.id.start_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkAsyncTask workAsyncTask = new WorkAsyncTask();
                workAsyncTask.execute();
            }
        });
    }

    private static class WorkAsyncTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i(TAG, "onPreExecute() - " + Thread.currentThread().getName());
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                for (int i = 0; i < 5; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    Log.i(TAG, "doInBackground() - " + Thread.currentThread().getName()
                            + " - message №" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.i(TAG, "onPostExecute() - " + Thread.currentThread().getName());
        }
    }
}
