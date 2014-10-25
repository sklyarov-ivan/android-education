package local.localhost.education.education;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;


public class CounterActivity extends Activity {
    Button addButton;
    Button subButton;
    TextView counterTextView;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        addButton = (Button) findViewById(R.id.addButton);
        subButton = (Button) findViewById(R.id.subButton);
        counterTextView = (TextView) findViewById(R.id.counterTextView);
        counter = 0;
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                counterTextView.setText(""+counter);
            }
        });
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                counterTextView.setText(""+counter);
            }
        });
    }
}
