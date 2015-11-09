package com.asha.nightowllib.observer;

import android.app.Activity;
import android.util.SparseArray;

/**
 * Created by hzqiujiadi on 15/11/9.
 * hzqiujiadi ashqalcn@gmail.com
 */
public class OwlObservable {
    private SparseArray<IOwlObserver> observers;
    public OwlObservable() {
        observers = new SparseArray<>();
    }

    public void registerObserver( IOwlObserver owlObserver ){
        observers.put(owlObserver.getObserverId(),owlObserver);
    }

    public void unregisterObserver( IOwlObserver owlObserver ){
        observers.delete(owlObserver.getObserverId());
    }

    public void notifyObserver(int mode, Activity activity){
        int size = observers.size();
        for (int i = 0; i < size; i++) {
            IOwlObserver owlObserver = observers.valueAt(i);
            owlObserver.onSkinChange(mode, activity);
        }
    }
}