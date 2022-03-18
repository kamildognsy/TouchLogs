package com.my.shakelogs;

import android.app.Activity;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

public class ThreeFingerDetection {
    private ThreeFingerDetection.IThreeFingerTouchListener listener;

    public ThreeFingerDetection(IThreeFingerTouchListener listener, MotionEvent event) {
        this.listener = listener;
        CalculateFingerCount(event);
    }

    public interface IThreeFingerTouchListener {
        void threeFingerTouch(int fingerCount);
    }

    public void CalculateFingerCount(MotionEvent event) {
        int action = event.getAction();
        int count = 0;
        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_POINTER_DOWN:
                count = event.getPointerCount();
                if(count == 3){
                    this.listener.threeFingerTouch(count);
                }
                break;
        }
    }


}
