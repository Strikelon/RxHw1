package com.strikalov.rxhw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ThirdActivity extends AppCompatActivity {

    private static String TAG = "MyLogger";

    private Button subscribeButton;
    private Button unsubscribeButton;

    private Disposable disposable;
    private Observable<Long> observable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        observable = Observable.interval(1, TimeUnit.SECONDS);

        subscribeButton = findViewById(R.id.subscribe_button);
        unsubscribeButton = findViewById(R.id.unsubscribe_button);

        subscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subscribe();
            }
        });

        unsubscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unsubscribe();
            }
        });
    }

    private void subscribe(){

        Log.i(TAG, "subscribe");

        if(observable != null){

            observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Long>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            disposable = d;
                        }

                        @Override
                        public void onNext(Long aLong) {
                            Log.i(TAG, "onNext: message" + aLong
                                    + " Thread: " + Thread.currentThread().getName());
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.i(TAG, "onError" + e);
                        }

                        @Override
                        public void onComplete() {
                            Log.i(TAG, "onComplete"
                                    + "Thread: " + Thread.currentThread().getName());
                        }
                    });

        }

    }

    private void unsubscribe(){
        Log.i(TAG, "unsubscribe");
        if(disposable != null){
            disposable.dispose();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(disposable != null){
            disposable.dispose();
        }
    }
}
