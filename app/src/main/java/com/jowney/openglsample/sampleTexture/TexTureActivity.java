package com.jowney.openglsample.sampleTexture;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/4/21/17:00
 * Description:
 */

public class TexTureActivity extends Activity {
    TextureGLSurfaceView  textureGLSurfaceView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textureGLSurfaceView = new TextureGLSurfaceView(this);
        setContentView(textureGLSurfaceView);
    }
}
