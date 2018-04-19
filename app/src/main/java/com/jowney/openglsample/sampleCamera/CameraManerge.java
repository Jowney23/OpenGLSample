package com.jowney.openglsample.sampleCamera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;

import java.io.IOException;

/**
 * Creator: Jowney  (~._.~)
 * Date: 2018/4/19/0:09
 * Description:
 */

public class CameraManerge {
    public static Camera camera;

    public static void openCamera(SurfaceTexture surfaceTexture) {
        camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK);
        try {
            camera.setPreviewTexture(surfaceTexture);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
