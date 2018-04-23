package com.jowney.openglsample.sampleTexture;

import android.opengl.GLES20;

import com.jowney.openglsample.common.BaseShape;

import java.nio.FloatBuffer;

/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/4/21/17:01
 * Description:
 */

public class Triangle extends BaseShape {
    final float UNIT_SIZE=0.15f;
    //图元顶点坐标数据的初始化
    private final float[] vertexCoords = {

            0.5f,0,0,
            0,1,0,
            1,1,0
    };
    //纹理顶点坐标数据的初始化
    private float[] textureCoords= {
                    0.5f,0,
                    0,1,
                    1,1
            };
    private final float color[] = { 0.63671875f, 0.76953125f, 0.22265625f, 1.0f };
    public Triangle(int textureId) {
        this.textureId = textureId;
        //第一步加载着色器
        vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);
        //第二步创建gles程序
        program = createProgram(vertexShader, fragmentShader);
        //第三步创建gles程序中的索引变量
        getShaderHandle();
        //获取顶点坐标
        vertexBuffer = getVertices(vertexCoords,4);
        //获取纹理坐标
        textureCoordsBuffer = getVertices(textureCoords,4);
        //图元顶点个数
        vertexCount = vertexCoords.length/3;
        //纹理顶点个数
        textureCount = textureCoords.length/2;
    }

    @Override
    public void getShaderHandle() {
        //顶点位置属性
        mPositionHandle = GLES20.glGetAttribLocation(program, "aPosition");
        //顶点纹理坐标
        mTextureHandle = GLES20.glGetAttribLocation(program, "aTexCoor");
        //总变换矩阵
        mMVPMatrixHandle = GLES20.glGetUniformLocation(program, "uMVPMatrix");

    }

    @Override
    public void draw(float[] mMVPMatrix) {
        // pass in the calculated transformation matrix
        // Add program to OpenGL ES environment
       GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT|GLES20.GL_DEPTH_BUFFER_BIT);
        GLES20.glUseProgram(program);


        // Enable a handle to the triangle vertices
        GLES20.glEnableVertexAttribArray(mPositionHandle);
        GLES20.glEnableVertexAttribArray(mTextureHandle);
        // Prepare the triangle coordinate data
        GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX,
                GLES20.GL_FLOAT, false,
                vertexStride, vertexBuffer);

        //为画笔指定顶点纹理坐标数据
        GLES20.glVertexAttribPointer(mTextureHandle, COORDS_PER_TEXTURE,
                GLES20.GL_FLOAT, false,
                textureStride, textureCoordsBuffer);


        // Set color for drawing the triangle
        // Pass the projection and view transformation to the shader
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mMVPMatrix, 0);


        //绑定纹理
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureId);
        // Draw the triangle
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount);

        // Disable vertex array
        GLES20.glDisableVertexAttribArray(mPositionHandle);
    }





    private final String fragmentShaderCode = "" +
            "precision mediump float;\n" +
            "varying vec2 vTextureCoord; \n" +
            "uniform sampler2D sTexture;\n" +
            "void main()                         \n" +
            "{           \n" +
            "             \n" +
            "   gl_FragColor = texture2D(sTexture, vTextureCoord); \n" +
            "}    ";

    private final String vertexShaderCode = "" +
            "uniform mat4 uMVPMatrix; \n" +
            "attribute vec3 aPosition; \n" +
            "attribute vec2 aTexCoor;   \n" +
            "uniform vec4 vColor;        \n" +
            "varying vec2 vTextureCoord;  \n" +
            "void main()     \n" +
            "{             \n" +
            "   gl_Position = uMVPMatrix * vec4(aPosition,1); \n" +
            "   vTextureCoord = aTexCoor;\n" +
            "} ";
}
