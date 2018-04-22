package com.jowney.openglsample.common;

import android.opengl.GLES20;
import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/4/15/21:07
 * Description:
 */

public abstract class BaseShape {
    // 每个点有几个坐标
    public final int COORDS_PER_VERTEX = 3;
    public final int COORDS_PER_TEXTURE = 2;
    public final int vertexStride = COORDS_PER_VERTEX * 4;
    public final int textureStride = COORDS_PER_TEXTURE * 4;
    public int vertexShader;
    public int fragmentShader;
    public int mPositionHandle;
    public int mColorHandle;
    public int mTextureHandle;
    public int mMVPMatrixHandle;
    public int program;

    public FloatBuffer vertexBuffer;
    public int vertexCount;
    public FloatBuffer textureCoordsBuffer;
    public int textureCount;
    public  int textureId;

    /**
     * 第一步加载着色器
     *
     * @param shaderType
     * @param sourceCode
     * @return
     */
    public int loadShader(int shaderType, String sourceCode) {
        // 创建一个新shader
        int shader = GLES20.glCreateShader(shaderType);
        // 若创建成功则加载shader
        if (shader != 0) {
            // 加载shader的源代码
            GLES20.glShaderSource(shader, sourceCode);
            // 编译shader
            GLES20.glCompileShader(shader);
            // 存放编译成功shader数量的数组
            int[] compiled = new int[1];
            // 获取Shader的编译情况
            GLES20.glGetShaderiv(shader, GLES20.GL_COMPILE_STATUS, compiled, 0);
            if (compiled[0] == 0) {//若编译失败则显示错误日志并删除此shader
                Log.e("ES20_ERROR", "Could not compile shader " + shaderType + ":");
                Log.e("ES20_ERROR", GLES20.glGetShaderInfoLog(shader));
                GLES20.glDeleteShader(shader);
                shader = 0;
            }
        }
        return shader;
    }

    /**
     * 第二步创建glsl程序
     *
     * @return
     */
    public int createProgram(int vertexShader, int fragmentShader) {
        // 创建程序
        int program = GLES20.glCreateProgram();
        // 若程序创建成功则向程序中加入顶点着色器与片元着色器
        if (program != 0) {
            // 向程序中加入顶点着色器
            GLES20.glAttachShader(program, vertexShader);
            // 向程序中加入片元着色器
            GLES20.glAttachShader(program, fragmentShader);
            // 链接程序
            GLES20.glLinkProgram(program);
            // 存放链接成功program数量的数组
            int[] linkStatus = new int[1];
            // 获取program的链接情况
            GLES20.glGetProgramiv(program, GLES20.GL_LINK_STATUS, linkStatus, 0);
            // 若链接失败则报错并删除程序
            if (linkStatus[0] != GLES20.GL_TRUE) {
                Log.e("ES20_ERROR", "Could not link program: ");
                Log.e("ES20_ERROR", GLES20.glGetProgramInfoLog(program));
                GLES20.glDeleteProgram(program);
                program = 0;
            }
        }
        return program;
    }

    /**
     * 第三步获取 shader 代码中的变量索引：
     */
    public abstract void getShaderHandle();

    /**
     * 第四步 获取点位置(涉及到大小头转换)
     *
     * @return
     */
    public FloatBuffer getVertices(float[] vertices, int byteCount) {

        // 创建顶点坐标数据缓冲
        // vertices.length*4是因为一个float占四个字节
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * byteCount);
        vbb.order(ByteOrder.nativeOrder());             //设置字节顺序
        FloatBuffer vertexBuf = vbb.asFloatBuffer();    //转换为Float型缓冲
        vertexBuf.put(vertices);                        //向缓冲区中放入顶点坐标数据
        vertexBuf.position(0);                          //设置缓冲区起始位置
        return vertexBuf;
    }

    public abstract void draw(float[] mMVPMatrix);
}
