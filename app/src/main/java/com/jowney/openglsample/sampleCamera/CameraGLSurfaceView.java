package com.jowney.openglsample.sampleCamera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;

/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/4/18/23:30
 * Description:
 */

public class CameraGLSurfaceView extends GLSurfaceView implements SurfaceTexture.OnFrameAvailableListener  {
    public CameraGLRender cameraGLRender;
    public CameraGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        cameraGLRender = new CameraGLRender(this);
        setRenderer(cameraGLRender);
        setRenderMode(RENDERMODE_WHEN_DIRTY);
    }


    @Override
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        requestRender();
    }
}
