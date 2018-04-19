package com.jowney.openglsample.sample06;


import com.jowney.openglsample.common.BaseGLRender;

/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/4/15/21:20
 * Description:
 */

public class MyGLRenderer06 extends BaseGLRender {
    //Render负责绘制画面到GLSurfaceView
    @Override
    public void initShape() {
        baseShape = new Square();
    }
}
