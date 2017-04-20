package com.android.lab3project;

import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String name = "user";
    EditText inputName;
    String info = "Info:\n1234 An Address, City, CA 92092\n(408) 123-4567";
    String err = "username not found";

    TextView text;
    Button display;
    Button newDisplay;

    TextView newText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        text = (TextView)findViewById(R.id.textDisplay);

        SharedPreferences sharedPrefs = getSharedPreferences("user_name", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putString("usernameKey", name);
        edit.apply();

        inputName = (EditText) findViewById(R.id.nameText);
        display = (Button) findViewById(R.id.displayButton);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display();
            }
        });

        newDisplay = (Button) findViewById((R.id.serviceData));
        newDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newText = (TextView) findViewById(R.id.newText);
                SharedPreferences prefs = getSharedPreferences("newPrefs", MODE_PRIVATE);
                String name = prefs.getString("name", "");
                newText.setText("test" + name);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    public void display() {
        SharedPreferences sharedPrefs = getSharedPreferences("user_name", MODE_PRIVATE);
        String prefName = sharedPrefs.getString("usernameKey", "");
        String inputText = inputName.getText().toString();
        if (prefName.equals(inputText)) {
            String displayInfo = "User '" + prefName + "' " + info;
            text.setText(displayInfo);
        } else {
            text.setText("Username '" + inputText + "' not found! ");
        }
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
}
