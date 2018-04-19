package com.jowney.openglsample.sampleCamera;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/4/18/23:23
 * Description:
 */

public class CameraActivity extends Activity {
    CameraGLSurfaceView mGLSurfaceView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGLSurfaceView = new CameraGLSurfaceView(this);
        setContentView(mGLSurfaceView);
    }

}
