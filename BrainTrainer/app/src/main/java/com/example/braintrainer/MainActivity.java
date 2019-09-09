package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button goButton;
    ConstraintLayout gameLayout;
    ArrayList <Integer> answers = new ArrayList<>();
    int locationOfCorrectAnswer;
    TextView resultTextView;
    TextView scoreTextView;
    TextView sumTextView;
    TextView timerTextView;
    Button playButton;
    Button button0, button1, button2, button3;
    int score = 0;
    int a;
    int b;
    int numberOfQuestions = 0;
    public void chooseAnswer(View view)
    {
       if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString()))
       {
           resultTextView = findViewById(R.id.resultTextView);
           resultTextView.setText("Correct! :)");
           score++;
       }
       else{
           resultTextView.setText("Wrong! :(");
       }
       numberOfQuestions++;
       scoreTextView.setText(Integer.toString(score)+ "/" +Integer.toString(numberOfQuestions));
       newQuestion();
    }
    public void start(View view)
    {
        goButton.setVisibility(View.INVISIBLE);
        playAgain(findViewById(R.id.button0));
        gameLayout.setVisibility(View.VISIBLE);
    }
    public void playAgain(View view)
    {
        playButton.setVisibility(View.INVISIBLE);
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score)+ "/" +Integer.toString(numberOfQuestions));
        newQuestion();
        new CountDownTimer(30100, 1000)
        {
            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("TIME'S UP!");
                playButton.setVisibility(View.VISIBLE);
            }
        }.start();
    }
    public void newQuestion()
    {
        Random rand = new Random();
        a = rand.nextInt(21);
        b = rand.nextInt(21);
        sumTextView.setText(Integer.toString(a)+"+"+Integer.toString(b));
        locationOfCorrectAnswer = rand.nextInt(4);
        answers.clear();
        for(int i=0; i<4; i++)
        {
            if(i == locationOfCorrectAnswer)
                answers.add(a+b);
            else
            {
                int wrongAnswer = rand.nextInt(41);
                while (wrongAnswer == a+b)
                {
                    wrongAnswer = rand.nextInt(41);
                }
                answers.add(rand.nextInt(41));
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sumTextView = findViewById(R.id.sumTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        goButton = findViewById(R.id.goButton);
        playButton = findViewById(R.id.playButton);
        timerTextView = findViewById(R.id.timerTextView);
        gameLayout = findViewById(R.id.gameLayout);
        goButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);
    }
}
