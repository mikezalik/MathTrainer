package com.mikezalik.mathtrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> answers = new ArrayList<Integer>();

    TextView resultTextView;
    TextView scoreTextView;
    TextView mathsTextView;
    TextView timerTextView;

    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;

    Button newGameButton;
    Button startButton;
    Button button0;
    Button button1;
    Button button2;
    Button button3;

    ConstraintLayout gameLayout;

    public void chooseAnswer(View view) {
        resultTextView.setVisibility(View.VISIBLE);
        if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
            resultTextView.setText(getString(R.string.Correct_Answer));
            score++;
        } else {
            resultTextView.setText(getString(R.string.Incorrect_Answer));
        }
        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        newQuestion();
    }

    public void newGame (View view) {
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText(getString(R.string.Timer_SetText));
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        newGameButton.setVisibility(View.INVISIBLE);
        resultTextView.setVisibility(View.INVISIBLE);
        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        newQuestion();


        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l / 1000) + "s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Time's up!");
                newGameButton.setVisibility(View.VISIBLE);
                button0.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
            }
        }.start();
    }

    public void start(View view) {
        startButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        newGame(findViewById(R.id.timerTextView));
    }

    public void newQuestion () {
        Random random = new Random();

        int a = random.nextInt(21);
        int b = random.nextInt(21);

        mathsTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = random.nextInt(4);

        answers.clear();

        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(a + b);
            } else {
                int wrongAnswer = random.nextInt(41);
                while (wrongAnswer == a + b) {
                    wrongAnswer = random.nextInt(41);
                }
                answers.add(wrongAnswer);
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

        resultTextView = findViewById(R.id.resultTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);
        mathsTextView = findViewById(R.id.mathsTextView);

        newGameButton = findViewById(R.id.newGameButton);
        startButton = findViewById(R.id.startButton);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        gameLayout = findViewById(R.id.gameLayout);

        startButton.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);
    }
}

//Dynamic questions?
/*
Rough sketch of dynamic question population based on answers being correct or incorrect. The idea is to increment or decrement the difficulty counter based on how they're answering. If they continue to answer
the questions correctly, the questions provided will become more difficult and vice versa.

int difficulty = 0;

public void dynamicTracking (View view) {
    if (questionCorrect == true) {
        difficulty + .03;
    } else {
        difficulty - .03;
    }
    return difficulty;
}

public void difficultyTracker (View view) {
    if (difficulty >= 4) {
        questionArray.get([4,4]); //access level 4 difficulty questions
    } else if (difficulty >= 5) {
        questionArray.get([5,5]); //access level 5 difficulty questions
    }
}
*/