package com.jowney.openglsample.sample03;

import android.content.Context;
import android.opengl.GLSurfaceView;


public class MyGLSurfaceView03 extends GLSurfaceView {

    private final MyGLRenderer3 mRenderer;

    public MyGLSurfaceView03(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        // Create a GLRenderer instance
        mRenderer = new MyGLRenderer3();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);

        // 可选选项，是将渲染模式设置为仅在你的绘制数据发生变化时才在视图中进行绘制操作
        // 如果选用这一配置选项，那么除非调用了requestRender()，否则GLSurfaceView不会被重新绘制，这样做可以让应用的性能及效率得到提高。
        setRenderMode(RENDERMODE_WHEN_DIRTY);
    }
}