package local.localhost.education.education;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MenuActivity extends ListActivity {

    String classes[] = {"Counter","TextManipulation","test 2","Photo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(MenuActivity.this,android.R.layout.simple_list_item_1, classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String className = classes[position];
        className = className+"Activity";
        try {
            Class selectedClass = Class.forName("local.localhost.education.education."+className);
            Intent newActivity = new Intent(MenuActivity.this, selectedClass);
            startActivity(newActivity);
        } catch (ClassNotFoundException e) {
            e.fillInStackTrace();
        }
    }
}
