package local.localhost.education.education;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class LoadActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        Thread timer = new Thread(){
            @Override
            public void run() {
                super.run();
                try {

                } catch (InterruptedException e) {

                } finally {

                }
            }
        };
        timer.start();
    }

}
