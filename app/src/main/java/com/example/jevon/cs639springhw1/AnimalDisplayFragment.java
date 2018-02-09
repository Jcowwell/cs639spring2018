package com.example.jevon.cs639springhw1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kachi on 1/31/18.
 */

 public class AnimalDisplayFragment extends AppCompatActivity {

    final String TAG = "AnimalDisplay";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_display);

       Log.d(TAG + " onCreate", "Success");
    }

    public void colorSwitch () {
        /*

        If no Animal Radio Buttons (ARB) are selected  : Present Toast Message

        If a Animal Radio


         */
    }
}
