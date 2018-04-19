package com.jowney.openglsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.jowney.openglsample.sampleCamera.CameraActivity;


/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/4/18/23:18
 * Description:
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goSampleCamera(View view){
        startActivity(new Intent(this, CameraActivity.class));
    }
}
