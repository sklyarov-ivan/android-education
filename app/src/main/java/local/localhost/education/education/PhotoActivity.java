package local.localhost.education.education;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;


public class PhotoActivity extends Activity implements View.OnClickListener {

    ImageButton ib;
    Button b;
    ImageView iv;
    final static int gCamera = 0;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        defineVars();

        InputStream is = getResources().openRawResource(R.drawable.load_image);
        bmp = BitmapFactory.decodeStream(is);
    }

    private void defineVars() {
        ib = (ImageButton) findViewById(R.id.ibMakeImage);
        b = (Button) findViewById(R.id.bApplyImage);
        iv = (ImageView) findViewById(R.id.ivReceiveImage);
        ib.setOnClickListener(this);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.ibMakeImage:
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, gCamera);
                break;
            case R.id.bApplyImage:

                try {
                    Context context = getApplicationContext();
                    WallpaperManager wpm = WallpaperManager.getInstance(context);
                    wpm.setBitmap(bmp);
                }catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data");
            iv.setImageBitmap(bmp);
        }
    }
}
