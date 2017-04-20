package lab3.android.com.sharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView firstView;
    TextView secondView;
    EditText firstText;
    EditText secondText;
    private String firstName;
    private String lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        firstView = (TextView) findViewById(R.id.firstText);
        secondView  = (TextView) findViewById(R.id.secondText);
        firstText = (EditText) findViewById(R.id.firstEdit);
        secondText = (EditText) findViewById(R.id.secondEdit);
        SharedPreferences sharedPrefs = getSharedPreferences("user_name", MODE_PRIVATE);
        firstName = sharedPrefs.getString("firstname", "");
        lastName = sharedPrefs.getString("lastname", "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void saveOnClick(View view) {
        SharedPreferences sharedPrefs = getSharedPreferences("user_name", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPrefs.edit();
        firstName = firstText.getText().toString();
        lastName = secondText.getText().toString();
        edit.putString("firstname", firstName);
        edit.putString("lastname", lastName);
        edit.apply();
        Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public void displayOnClick(View view) {
        SharedPreferences sharedPrefs = getSharedPreferences("user_name", MODE_PRIVATE);
        firstName = sharedPrefs.getString("firstname", "");
        lastName = sharedPrefs.getString("lastname", "");
        firstView.setText(firstName);
        secondView.setText(lastName);
    }
}
