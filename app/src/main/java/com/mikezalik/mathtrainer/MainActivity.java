package com.mikezalik.mathtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;

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

        Random random = new Random();

        int a = random.nextInt(21);
        int b = random.nextInt(21);
    }
}
