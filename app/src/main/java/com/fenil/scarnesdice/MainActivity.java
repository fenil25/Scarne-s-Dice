package com.fenil.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView dice;
    Button roll;
    Button hold;
    Button reset;
    TextView your_score;
    TextView current_score;
    TextView computer_score;
    TextView computer_current_score;

    Random rand = new Random();
    int rolledNumber;

    int my_total_score = 0;
    int my_current_score = 0;
    int pc_total_score = 0;
    int pc_current_score = 0;
    int turn = 1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice = (ImageView) findViewById(R.id.dice);
        roll = (Button) findViewById(R.id.roll);
        hold = (Button) findViewById(R.id.hold);
        reset = (Button) findViewById(R.id.reset);
        your_score = (TextView) findViewById(R.id.your_score);
        current_score = (TextView) findViewById(R.id.current_score);
        computer_score = (TextView) findViewById(R.id.computer_score);
        computer_current_score = (TextView) findViewById(R.id.computer_current_score);

        roll.setOnClickListener(this);
        hold.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.roll && turn==1)
        {
            rolledNumber = rand.nextInt(6) + 1;

            if(rolledNumber == 1)
            {
                dice.animate().rotationBy(250f).setDuration(100);
                dice.setImageResource(R.drawable.dice1);
                my_current_score = 0;
                turn = 2;
                current_score.setText("Your Score: "+my_current_score);
            }
            else if(rolledNumber == 2)
            {
                dice.animate().rotationBy(250f).setDuration(100);
                dice.setImageResource(R.drawable.dice2);
                my_current_score = my_current_score + 2;
                current_score.setText("Your Score: "+my_current_score);
            }
            else if(rolledNumber == 3)
            {
                dice.animate().rotationBy(250f).setDuration(100);
                dice.setImageResource(R.drawable.dice3);
                my_current_score = my_current_score + 3;
                current_score.setText("Your Score: "+my_current_score);
            }
            else if(rolledNumber == 4)
            {
                dice.animate().rotationBy(250f).setDuration(100);
                dice.setImageResource(R.drawable.dice4);
                my_current_score = my_current_score + 4;
                current_score.setText("Your Score: "+my_current_score);
            }
            else if(rolledNumber == 5)
            {
                dice.animate().rotationBy(250f).setDuration(100);
                dice.setImageResource(R.drawable.dice5);
                my_current_score = my_current_score + 5;
                current_score.setText("Your Score: "+my_current_score);
            }
            else if(rolledNumber == 6)
            {
                dice.animate().rotationBy(250f).setDuration(100);
                dice.setImageResource(R.drawable.dice6);
                my_current_score = my_current_score + 6;
                current_score.setText("Your Score: "+my_current_score);
            }
        }

        if(view.getId()== R.id.hold && turn==1)
        {
            my_total_score = my_total_score + my_current_score;
            my_current_score = 0;
            turn = 2;

            current_score.setText("Your Score: "+my_current_score);
            your_score.setText("Your Current Score: "+my_total_score);
        }

        if(view.getId() == R.id.reset)
        {
            my_current_score = 0;
            my_total_score = 0;
            pc_current_score = 0;
            pc_total_score = 0;
            turn = 1;

            current_score.setText("Your Score: "+my_current_score);
            your_score.setText("Your Current Score: "+my_total_score);
            computer_current_score.setText("PC Current Score: " + pc_current_score);
            computer_score.setText("Computer's Score: " + pc_total_score);
        }

        if(turn == 2)
        {
            rolledNumber = 0;

            while(rolledNumber != 1 && pc_current_score <= 20)
            {
                rolledNumber = rand.nextInt(6) + 1;
                pc_current_score = pc_current_score + rolledNumber;
                computer_current_score.setText("PC Current Score: " + pc_current_score);
                Log.i("computer dice value", ""+rolledNumber);
            }

            if(rolledNumber == 1)
            {
                pc_current_score = 0;
                computer_current_score.setText("PC Current Score: " + pc_current_score);
                turn = 1;
            }
            else
            {
                pc_total_score = pc_total_score + pc_current_score;
                pc_current_score = 0;
                computer_current_score.setText("PC Current Score: " + pc_current_score);
                computer_score.setText("Computer's Score: " + pc_total_score);
                turn = 1;
            }

            if(pc_total_score>=100)
            {
                Toast.makeText(this, "Computer Wins", Toast.LENGTH_LONG).show();

                my_current_score = 0;
                my_total_score = 0;
                pc_current_score = 0;
                pc_total_score = 0;
                turn = 1;

                current_score.setText("Your Score: "+my_current_score);
                your_score.setText("Your Current Score: "+my_total_score);
                computer_current_score.setText("PC Current Score: " + pc_current_score);
                computer_score.setText("Computer's Score: " + pc_total_score);
            }

            if(my_total_score>=100)
            {
                Toast.makeText(this, "Human Wins", Toast.LENGTH_LONG).show();

                my_current_score = 0;
                my_total_score = 0;
                pc_current_score = 0;
                pc_total_score = 0;
                turn = 1;

                current_score.setText("Your Score: "+my_current_score);
                your_score.setText("Your Current Score: "+my_total_score);
                computer_current_score.setText("PC Current Score: " + pc_current_score);
                computer_score.setText("Computer's Score: " + pc_total_score);
            }
        }
    }
}
