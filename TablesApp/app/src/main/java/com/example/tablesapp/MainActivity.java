package com.example.tablesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView listView;
    SeekBar seekBar;
    ArrayList<String> number = new ArrayList<>();

    public void check(View view)
    {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                number.clear();
                seekBar.setProgress(2);
                int num=1;
                while(num<=10){
                    number.add(" "+num*progress);
                    num++;
                }
            listView = findViewById(R.id.listView);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, number);
            listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar.setProgress(9);
        int num=1;
        while(num<=10){
            number.add(" "+num*seekBar.getProgress());
            num++;
        }
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, number);
        listView.setAdapter(arrayAdapter);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                number.clear();
                if(progress<2){
                    seekBar.setProgress(2);
                }
                int num=1;
                while(num<=10){
                    number.add(" "+num*seekBar.getProgress());
                    num++;
                }
                listView = findViewById(R.id.listView);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, number);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Toast.makeText(this, "Change the slider to change the times tables value!", Toast.LENGTH_LONG).show();
    }
}
