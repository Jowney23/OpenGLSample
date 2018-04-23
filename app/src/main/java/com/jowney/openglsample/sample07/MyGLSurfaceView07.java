package com.jowney.openglsample.sample07;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by Jowney on 2018/4/23.
 */

public class MyGLSurfaceView07 extends GLSurfaceView {
    public MyGLSurfaceView07(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        MyGLRender07 myGLRender07 = new MyGLRender07();
        setRenderer(myGLRender07);
        setRenderMode(RENDERMODE_CONTINUOUSLY);
    }
}
