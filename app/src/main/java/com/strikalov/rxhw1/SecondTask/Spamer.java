package com.strikalov.rxhw1.SecondTask;

import java.util.ArrayList;
import java.util.List;

public class Spamer {

    private int spamNumber;
    private List<SpamObserver> subscribers;

    public Spamer(){
        spamNumber = 1;
        subscribers = new ArrayList<>();
    }

    public void subscribe(SpamObserver spamObserver){
        subscribers.add(spamObserver);
    }

    public void unsubscribe(SpamObserver spamObserver){
        subscribers.remove(spamObserver);
    }

    public void spam(){
        for(SpamObserver spamObserver : subscribers){
            spamObserver.getMessage(spamNumber);
        }
        spamNumber++;
    }

}
