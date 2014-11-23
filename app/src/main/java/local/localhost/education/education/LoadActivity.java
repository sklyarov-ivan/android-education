package local.localhost.education.education;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class LoadActivity extends Activity {
    MediaPlayer loadSong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        loadSong = MediaPlayer.create(LoadActivity.this, R.raw.load_song);
        loadSong.start();
        Thread timer = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.fillInStackTrace();
                } finally {
                    Intent counterActivity = new Intent("local.localhost.education.education.MENUACTIVITY");
                    startActivity(counterActivity);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
        loadSong.release();
    }
}
