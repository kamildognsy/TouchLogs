package com.my.shakelogs;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.util.FloatMath;

public class ShakeDetection implements SensorEventListener {
    private ShakeDetection.IShakeDetector listener;
    private static final float SHAKE_THRESHOLD_GRAVITY = 2.7F;

    public ShakeDetection(IShakeDetector listener) {
        this.listener = listener;
    }

    public interface IShakeDetector {
        void shakeIt(float gforce);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(listener != null){
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            float gX = x / SensorManager.GRAVITY_EARTH;
            float gY = y / SensorManager.GRAVITY_EARTH;
            float gZ = z / SensorManager.GRAVITY_EARTH;

            // gForce will be close to 1 when there is no movement.
            float gForce = (float) Math.sqrt(gX * gX + gY * gY + gZ * gZ);
            if(gForce > SHAKE_THRESHOLD_GRAVITY){
                listener.shakeIt(gForce);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
