package com.mikezalik.mathtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    ArrayList<Integer> answers = new ArrayList<Integer>();

    public void start(View view) {
        startButton.setVisibility(View.INVISIBLE);
    }

    public void chooseAnswer(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);

        TextView mathsTextView = findViewById(R.id.mathsTextView);

        Random random = new Random();

        int a = random.nextInt(21);
        int b = random.nextInt(21);

        mathsTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        int locationOfCorrectAnswer = random.nextInt(4);

        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(a + b);
            } else {
                answers.add(random.nextInt(41));
            }
        }
    }
}
