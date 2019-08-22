package com.example.numberguessing;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    int randomNumber;
    int guess_count = 0;

    public void generateRandomNumber()
    {
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }

    public void guess(View view)
    {
        EditText editText = findViewById(R.id.editText);
        int user_guess = Integer.parseInt(editText.getText().toString());

        String message;
        if (user_guess > 20 || user_guess < 0)
        {
            message = "Please enter a value between 0 to 20.";
            guess_count = guess_count + 1;
        }
        else if(user_guess > randomNumber)
        {
            message = "You guessed a little higher.";
            guess_count = guess_count + 1;
        }
        else if(user_guess < randomNumber)
        {
            message = "You guessed a little lower.";
            guess_count = guess_count + 1;
        }
        else{
            message = "BINGO! You guessed it right";
            generateRandomNumber();
        }
        Toast.makeText(this, message + "Number of guesses: "+ guess_count, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();

    }
}
