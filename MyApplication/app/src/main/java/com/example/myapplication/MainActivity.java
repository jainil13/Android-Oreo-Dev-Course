package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    public void clickFunction(View view)
    {
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        EditText pwd = (EditText) findViewById(R.id.pwd);

        Log.i("info", "Button Clicked!");
        Log.i("username:", nameEditText.getText().toString());
        Log.i("password", pwd.getText().toString());

        Toast.makeText(this, "Hello " + nameEditText.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
