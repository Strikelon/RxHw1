package com.strikalov.rxhw1.SecondTask;

import android.util.Log;

public class SpamObserver {

    private static String TAG = "MyLogger";

    public void getMessage(int number){
        Log.i(TAG, "Thread: "+ Thread.currentThread().getName() +" Spam №" + number);
    }

}
