package com.my.shakelog;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

import com.my.shakelogs.LogModel;
import com.my.shakelogs.ShakeDetection;
import com.my.shakelogs.ThreeFingerDetection;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements ThreeFingerDetection.IThreeFingerTouchListener{

    TextView tv;
    ThreeFingerDetection log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        LogModel model = new LogModel("HATA HATA HATA" , "REQUEST KAMİL" , "RESPONSE 200" , "132123");
        LogModel model2 = new LogModel("ERR" , "REQUEST KAMİL" , "RESPONSE 200" , "13233");
        LogModel model3 = new LogModel("kml dgnsy" , "REQUEST KAMİL" , "RESPONSE 200" , "132123");
        LogModel model4 = new LogModel("deneme" , "REQUEST KAMİL" , "RESPONSE 200" , "13211");

        log = new ThreeFingerDetection(getApplicationContext());
        log.addLog(model);
        log.addLog(model2);
        log.addLog(model3);
        log.addLog(model4);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        new ThreeFingerDetection(this,this, event);
        return super.onTouchEvent(event);
    }


    @Override
    public void threeFingerTouch(ArrayList<LogModel> logList) {
        System.out.println("LOG LİST GELDİ BE");
    }
}