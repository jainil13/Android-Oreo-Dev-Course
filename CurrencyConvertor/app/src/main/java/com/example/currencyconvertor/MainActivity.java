package com.example.currencyconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{

    public void convert(View view)
    {
        Log.i("INFO", "button pressed!");
        EditText editText = (EditText) findViewById(R.id.editText);

        String amountInINR = editText.getText().toString();

        double amountInINRd = Double.parseDouble(amountInINR);
        double amountInUSDd = amountInINRd / 71.60;

        DecimalFormat formatter = new DecimalFormat("#0.00");
        String USD = (formatter.format(amountInUSDd));

        Toast.makeText(this, " "+ amountInINRd+" rupees is "+" $: "+USD, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
