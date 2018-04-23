package com.jowney.openglsample.sampleTexture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;

import com.jowney.openglsample.common.BaseGLRender;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/4/21/17:03
 * Description:
 */

public class TextureRender extends BaseGLRender {
   private Bitmap bitmapTmp;
    private int textureId;

    public TextureRender(Bitmap bitmapTmp) {
        this.bitmapTmp = bitmapTmp;
    }

    @Override
    public void initShape() {
        baseShape = new Triangle(textureId);
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        //打开深度检测
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);
        //初始化纹理
        initTexture();
        //关闭背面裁剪
        GLES20.glDisable(GLES20.GL_CULL_FACE);
        super.onSurfaceCreated(gl10, eglConfig);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        super.onSurfaceChanged(gl10, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        super.onDrawFrame(gl10);
    }

    public void initTexture()//textureId
    {

        int[] textures = new int[1];
        GLES20.glGenTextures
                (
                        1,//生成纹理ID的数量
                        textures,
                        0
                );
        textureId=textures[0];
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureId); //绑定纹理ID
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER,GLES20.GL_NEAREST); //设置MIN采样方式
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D,GLES20.GL_TEXTURE_MAG_FILTER,GLES20.GL_LINEAR);//设置MAG采样方式
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S,GLES20.GL_CLAMP_TO_EDGE);//设置S轴拉伸方式
        GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T,GLES20.GL_CLAMP_TO_EDGE);//设置T轴拉伸方式
//将纹理加载进显存
        GLUtils.texImage2D(
                        GLES20.GL_TEXTURE_2D,//纹理类型
                        0,//纹理层次，0表示基本图像层，  可以理解为直接贴图
                        bitmapTmp,//纹理图像
                        0//纹理边框尺寸
                            );
        bitmapTmp.recycle();
    }
}
