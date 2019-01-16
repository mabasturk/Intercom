package com.denizhan.intercom.Media;

/*
    Yazacak Olan: Buğra
    Açıklama: 3gp formatında video kaydedici
*/
import android.hardware.Camera;
import android.view.SurfaceView;
import com.denizhan.intercom.Interfaces.ActivityMediaInteractionInterface;
import java.io.IOException;


public class CustomVideoRecorder implements ActivityMediaInteractionInterface{

    private Camera camera; // video kamerası
    private SurfaceView surface_view; // video kaydedilirken gösterileceği zemin
    private boolean previewing = false;
    public CustomVideoRecorder(SurfaceView surfaceview){
        this.surface_view = surfaceview;
    }

    @Override
    public void prepare() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    public void startPreview(){
        try {
            this.camera = Camera.open(1); // ön kamerayı aç
            this.camera.setPreviewDisplay(this.surface_view.getHolder()); // oynatma yüzeyini belirle
            this.camera.startPreview(); // previewi başlat
            this.previewing = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopPreview(){
        this.camera.stopPreview(); // previewi durdur
        this.camera.release(); // kamerayı kapat
        this.previewing = false;
    }
}
