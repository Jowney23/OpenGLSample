package com.jowney.openglsample.sample06;

import android.opengl.GLES20;

import com.jowney.openglsample.common.BaseShape;


/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/4/15/23:50
 * Description:
 */

public class Square extends BaseShape {
    // 图像顶点坐标以逆时针顺序;
    private final float vertexesCoords[] = {
            0.5f,  0.5f, 0.0f, // top
            -0.5f, -0.5f, 0.0f, // bottom left
            0.5f, -0.5f, 0.0f  // bottom right

         /*   1f, -0f, 0.0f, // bottom left
            -0f,  1f, 0.0f, // top left
            0f, -0f, 0.0f // bottom right*/
        /*    -0.3f,  0.6f, 0.0f, // top left
            0.9f, -0.6f, 0.0f, // bottom right
            0.9f,  0.6f, 0.0f  // top right
*/
    };
    private final float color[] = { 0.63671875f, 0.76953125f, 0.22265625f, 1.0f };
    //在构造方法里面创建opengl
    public Square() {
        //第一步加载着色器
        vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
        fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);
        //第二步创建gles程序
        program = createProgram(vertexShader, fragmentShader);
        //第三步创建gles程序中的变量索引
        getShaderHandle();
        //第四步  获取点的位置
        vertexBuffer =  getVertices(vertexesCoords,4);
        //获取顶点个数
        vertexCount = vertexesCoords.length / COORDS_PER_VERTEX;
    }

    @Override
    public void getShaderHandle() {
        mPositionHandle = GLES20.glGetAttribLocation(program,"vPosition");
        mColorHandle = GLES20.glGetUniformLocation(program, "vColor");
        mMVPMatrixHandle = GLES20.glGetUniformLocation(program, "uMVPMatrix");
    }

    @Override
    public void draw(float[] mMVPMatrix) {
        // pass in the calculated transformation matrix
        // Add program to OpenGL ES environment
        GLES20.glUseProgram(program);


        // Enable a handle to the triangle vertices
        GLES20.glEnableVertexAttribArray(mPositionHandle);

        // Prepare the triangle coordinate data
        GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX,
                GLES20.GL_FLOAT, false,
                vertexStride, vertexBuffer);


        // Set color for drawing the triangle
        GLES20.glUniform4fv(mColorHandle, 1, color, 0);



        // Pass the projection and view transformation to the shader
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mMVPMatrix, 0);

        // Draw the triangle
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount);

        // Disable vertex array
        GLES20.glDisableVertexAttribArray(mPositionHandle);

    }

    /**
     * 顶点着色器代码
     * attribute变量(属性变量)只能用于顶点着色器中，不能用于片元着色器。一般用该变量来表示一些顶点数据，如：顶点坐标、纹理坐标、颜色等
     * uniforms变量(一致变量)用来将数据值从应用程其序传递到顶点着色器或者片元着色器。 该变量有点类似C语言中的常量（const），即该变量的值不能被shader程序修改。一般用该变量表示变换矩阵、光照参数、纹理采样器等。
     * varying变量(易变变量)是从顶点着色器传递到片元着色器的数据变量。顶点着色器可以使用易变变量来传递需要插值的颜色、法向量、纹理坐标等任意值。 在顶点与片元shader程序间传递数据是很容易的，一般在顶点shader中修改varying变量值，然后片元shader中使用该值，当然，该变量在顶点及片元这两段shader程序中声明必须是一致的。
     * gl_Position 为内建变量，表示变换后点的空间位置。 顶点着色器从应用程序中获得原始的顶点位置数据，这些原始的顶点数据在顶点着色器中经过平移、旋转、缩放等数学变换后，生成新的顶点位置。新的顶点位置通过在顶点着色器中写入gl_Position传递到渲染管线的后继阶段继续处理。
     */
    private final String vertexShaderCode =
            // This matrix member variable provides a hook to manipulate
            // the coordinates of the objects that use this vertex shader
            "uniform mat4 uMVPMatrix;" +
                    "attribute vec4 vPosition;" +  // 应用程序传入顶点着色器的顶点位置
                    "void main() {" +
                    // the matrix must be included as a modifier of gl_Position
                    // Note that the uMVPMatrix factor *must be first* in order
                    // for the matrix multiplication product to be correct.
                    "  gl_Position = uMVPMatrix * vPosition;" + // 设置此次绘制此顶点位置
                    "}";

    /**
     * 片元着色器代码
     */
    private final String fragmentShaderCode =
            "precision mediump float;" +  // 设置工作精度
                    "uniform vec4 vColor;" +  // 应用程序传入着色器的颜色变量
                    "void main() {" +
                    "  gl_FragColor = vColor;" + // 颜色值传给gl_FragColor内建变量，完成片元的着色
                    "}";

}
