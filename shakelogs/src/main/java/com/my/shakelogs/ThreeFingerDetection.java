package com.my.shakelogs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;

import com.my.shakelogs.Activitys.LogListActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class ThreeFingerDetection {
    private Context context;

    public ThreeFingerDetection(Context context) {
        this.context = context;
    }

    public ThreeFingerDetection(Context context,MotionEvent event) {
        this.context = context;
        CalculateFingerCount(event);
    }

    public void CalculateFingerCount(MotionEvent event) {
        int action = event.getAction();
        int count = 0;
        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_POINTER_DOWN:
                count = event.getPointerCount();
                if(count == 3){
                    //this.listener.threeFingerTouch(getLogs());
                    System.out.println("Girdi");
                    Intent intent = new Intent(context , LogListActivity.class);
                    List<LogModel> list = new ArrayList<>();
                    list = getLogs();
                    intent.putExtra("logList" , (Serializable) list);
                    context.startActivity(intent);
                }
                break;
        }
    }

    private ArrayList<LogModel> getLogs(){
        ArrayList<LogModel> logList = new ArrayList<>();
        LogDatabaseHelper db = new LogDatabaseHelper(context);
        logList = db.getLogsList();
        db.close();
        return logList;
    }

   public void addLog(LogModel model){
        LogDatabaseHelper db = new LogDatabaseHelper(context);
        db.createLog(model);
        db.close();
   }

   public void deleteLogs(String logId){
       LogDatabaseHelper db = new LogDatabaseHelper(context);
       db.deleteLog(logId);
       db.close();
   }


}
