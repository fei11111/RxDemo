package com.fei.rxdemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.fei.rxdemo.rxjava.Customer;
import com.fei.rxdemo.rxjava.Function;
import com.fei.rxdemo.rxjava.Observable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable.just("xxxx").map(new Function<String, Bitmap>() {

            @Override
            public Bitmap apply(String str) {
                Log.i("tag", "apply");
                return null;
            }

        }).map(new Function<Bitmap, Bitmap>() {
            @Override
            public Bitmap apply(Bitmap bitmap) {
                return null;
            }
        }).subscribe(new Customer<Bitmap>() {
            @Override
            public void onNext(Bitmap bitmap) {
                Log.i("tag", "onNext");
            }
        });

    }
}