package com.jowney.openglsample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.jowney.openglsample.sample01.OpenGLSample01Activity;
import com.jowney.openglsample.sample02.OpenGLSample02Activity;
import com.jowney.openglsample.sample03.OpenGLSample03Activity;
import com.jowney.openglsample.sample04.OpenGLSample04Activity;
import com.jowney.openglsample.sample05.OpenGLSample05Activity;
import com.jowney.openglsample.sample06.OpenGLSample06Activity;
import com.jowney.openglsample.sampleTexture.TexTureActivity;

import java.io.IOException;
import java.io.InputStream;


public class ShapeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);

    }
    public void goSample01(View view) {
        startActivity(new Intent(this, OpenGLSample01Activity.class));
    }

    public void goSample02(View view) {
        startActivity(new Intent(this, OpenGLSample02Activity.class));
    }

    public void goSample03(View view) {
        startActivity(new Intent(this, OpenGLSample03Activity.class));
    }

    public void goSample04(View view) {
        startActivity(new Intent(this, OpenGLSample04Activity.class));
    }

    public void goSample05(View view) {
        startActivity(new Intent(this, OpenGLSample05Activity.class));
    }

    public void goSample06(View view){
        startActivity(new Intent(this, OpenGLSample06Activity.class));
    }
    public void goTextureSample(View view){
        startActivity(new Intent(this, TexTureActivity.class));
    }
}
