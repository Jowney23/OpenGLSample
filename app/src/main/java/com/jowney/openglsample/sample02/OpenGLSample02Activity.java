package com.jowney.openglsample.sample02;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jowney.openglsample.R;


public class OpenGLSample02Activity extends AppCompatActivity{

    MyGLSurfaceView2 mGLSurfaceView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("OpenGLSample02");
        // Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity.
        mGLSurfaceView = new MyGLSurfaceView2(this);
        setContentView(mGLSurfaceView);
    }
}
