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
import com.my.shakelogs.model1;
import com.my.shakelogs.model2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    TextView tv;
    ThreeFingerDetection log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        model1 mod1 = new model1();
        model2 mod2 = new model2();
        ArrayList<model2> list = new ArrayList<>();

        mod2.setIsim("Kamil");
        mod2.setKangrubu("A+");
        mod2.setYas("25");
        list.add(mod2);

        model2 mod22 = new model2();
        mod22.setIsim("Kemaaal");
        mod22.setKangrubu("B0");
        mod22.setYas("105");
        list.add(mod22);

        mod1.setIduser("123");
        mod1.setCinsiyet("Erkek");
        mod1.setEhliyet("A2");
        mod1.setKisilik(list);



        LogModel model = new LogModel("Hata alındı alooo" , mod1 , mod2 , "555");

        log = new ThreeFingerDetection(getApplicationContext());
        log.addLog(model);

        /*LogModel model = new LogModel("HATA HATA HATA" , "REQUEST KAMİL" , "RESPONSE 200" , "132123");
        LogModel model2 = new LogModel("ERR" , "REQUEST KAMİL" , "RESPONSE 200" , "13233");
        LogModel model3 = new LogModel("kml dgnsy" , "REQUEST KAMİL" , "RESPONSE 200" , "132123");
        LogModel model4 = new LogModel("deneme" , "REQUEST KAMİL" , "RESPONSE 200" , "13211");

        log = new ThreeFingerDetection(getApplicationContext());
        log.addLog(model);
        log.addLog(model2);
        log.addLog(model3);
        log.addLog(model4);*/


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        new ThreeFingerDetection(this, event);
        return super.onTouchEvent(event);
    }

}