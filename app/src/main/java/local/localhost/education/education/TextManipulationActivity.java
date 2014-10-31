package local.localhost.education.education;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.graphics.Color;

import java.util.Random;


public class TextManipulationActivity extends Activity implements View.OnClickListener {


    TextView manipulate;
    Button submit;
    ToggleButton toggleVisibility;
    EditText command;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_manipulation);
        setViewVars();
        submit.setOnClickListener(this);
        toggleVisibility.setOnClickListener(this);
    }

    private void setViewVars() {
        manipulate = (TextView) findViewById(R.id.manupulateTextView);
        submit = (Button) findViewById(R.id.submitButton);
        toggleVisibility = (ToggleButton) findViewById(R.id.tbToggleButton);
        command = (EditText) findViewById(R.id.commandEditText);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.submitButton:
                String check = command.getText().toString();
                manipulate.setText(check);
                if (check.contentEquals("left")) {
                    manipulate.setGravity(Gravity.LEFT);
                } else if (check.contentEquals("center")) {
                    manipulate.setGravity(Gravity.CENTER);
                } else if (check.contentEquals("right")) {
                    manipulate.setGravity(Gravity.RIGHT);
                } else if (check.contains("WTF")) {
                    Random crazy = new Random();
                    manipulate.setText("WTF!!!!");
                    manipulate.setTextSize(crazy.nextInt(75));
                    manipulate.setTextColor(Color.rgb(crazy.nextInt(255),crazy.nextInt(255),crazy.nextInt(255)));
                    switch (crazy.nextInt(3)) {
                        case 0:
                            manipulate.setGravity(Gravity.RIGHT);
                            break;
                        case 1:
                            manipulate.setGravity(Gravity.LEFT);
                            break;
                        case 2:
                            manipulate.setGravity(Gravity.CENTER);
                            break;
                    }
                } else {
                    manipulate.setTextSize(20);
                    manipulate.setText("incorrect");
                    manipulate.setGravity(Gravity.CENTER);
                    manipulate.setTextColor(Color.BLUE);


                }
                break;
            case R.id.tbToggleButton:
                if (toggleVisibility.isChecked()) {
                    command.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    command.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                break;
        }
    }
}
