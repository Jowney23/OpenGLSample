package com.jowney.openglsample.sample07;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Jowney on 2018/4/23.
 */

public class OpenGLSample07Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyGLSurfaceView07 myGLSurfaceView07 = new MyGLSurfaceView07(this);
        setContentView(myGLSurfaceView07);
    }
}
