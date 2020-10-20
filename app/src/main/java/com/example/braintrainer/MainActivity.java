package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;




public class MainActivity extends AppCompatActivity {

    Button randomFirst;
    Button randomSecond;
    Button randomThird;
    Button randomFourth;


    public void playBrainer (View view){

        Button buttonPressed = (Button) view;

        Log.i("Button Pressed", buttonPressed.getTag().toString());



    }

    public void randomNumber(){

        Random rand = new Random();
        int first = rand.nextInt(50);
        int second = rand.nextInt(50);
        int third = rand.nextInt(50);
        int fourth = rand.nextInt(50);

        randomFirst.setText(Integer.toString(first));
        randomSecond.setText(Integer.toString(second));
        randomThird.setText(Integer.toString(third));
        randomFourth.setText(Integer.toString(fourth));


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonPlay = (Button) findViewById(R.id.button10);
        randomFirst = (Button) findViewById(R.id.button2);
        randomSecond = (Button) findViewById(R.id.button3);
        randomThird = (Button) findViewById(R.id.button4);
        randomFourth = (Button) findViewById(R.id.button5);
        final Button buttonCountDown = (Button) findViewById(R.id.button6);
        final TextView answerText = (TextView) findViewById(R.id.answerTextView);

        randomNumber();

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buttonPlay.setVisibility(View.INVISIBLE);
                answerText.setVisibility(View.INVISIBLE);

                CountDownTimer countDownTimer = new CountDownTimer(20000 + 100, 1000) {
                    @Override
                    public void onTick(long l) {

                        buttonCountDown.setText(Integer.toString((int) (l / 1000)) + "s");
                    }

                    @Override
                    public void onFinish() {
                        answerText.setVisibility(View.VISIBLE);
                        answerText.setText("DONE");
                        buttonPlay.setText("PLAY AGAIN");
                        buttonPlay.setVisibility(View.VISIBLE);
                    }
                }.start();


            }
        });
    }
}