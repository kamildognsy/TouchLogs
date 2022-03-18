package com.my.shakelog;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import com.my.shakelogs.ShakeDetection;
import com.my.shakelogs.ThreeFingerDetection;

public class MainActivity extends AppCompatActivity implements ThreeFingerDetection.IThreeFingerTouchListener{

    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        new ThreeFingerDetection(MainActivity.this , event);
        return super.onTouchEvent(event);
    }

    @Override
    public void threeFingerTouch(int fingerCount) {
        System.out.println(fingerCount + " parmak ile basıldı");
    }
}