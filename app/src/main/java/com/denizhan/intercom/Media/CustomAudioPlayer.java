package com.denizhan.intercom.Media;

import android.media.MediaPlayer;
import com.external.test.Interfaces.ActivityMediaInteractionInterface;

import java.io.IOException;

public class CustomAudioPlayer implements ActivityMediaInteractionInterface {

    private MediaPlayer player; // Android'in kendi medya oynatıcısı

    public CustomAudioPlayer()
    {
        player = new MediaPlayer();
    }

    @Override
    public void prepare()
    {
        try
        {
            player.setDataSource("/storage/emulated/0/sample.3gp"); // Oynatılacak dosyayı seç
            player.prepare(); // Oynatma için hazırlan
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void start()
    {
        player.start(); // Oynatmayı başlat
    }

    @Override
    public void stop()
    {
        player.stop(); // Oynatmayı durdur
    }

    @Override
    public void destroy()
    {
        player.release(); // MediaPlayer objesini ve kullandığı kaynakları temizle
    }
}