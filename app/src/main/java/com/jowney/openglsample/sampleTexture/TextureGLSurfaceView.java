package com.jowney.openglsample.sampleTexture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.util.TypedValue;

import com.jowney.openglsample.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/4/21/17:04
 * Description:
 */

public class TextureGLSurfaceView extends GLSurfaceView {
    private TextureRender textureRender;
    private Bitmap bitmapTmp;

    public TextureGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        InputStream is = context.getResources().openRawResource(+R.drawable.wall);
        try {

            bitmapTmp = BitmapFactory.decodeStream(is);
            is.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        textureRender = new TextureRender(bitmapTmp);
        setRenderer(textureRender);
        setRenderMode(RENDERMODE_CONTINUOUSLY);
    }
}
