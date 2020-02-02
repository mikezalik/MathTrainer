package com.mikezalik.mathtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;

    public void chooseAnswer(View view) {
        if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
            Log.i("Correct!", "You got the right answer!");
        } else {
            Log.i("Wrong!", "Wrong answer!");
        }
    }

    public void start(View view) {
        startButton.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);

        TextView mathsTextView = findViewById(R.id.mathsTextView);
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        Random random = new Random();

        int a = random.nextInt(21);
        int b = random.nextInt(21);

        mathsTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = random.nextInt(4);

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
}

/*
Rough sketch of dynamic question population based on answers being correct or incorrect

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