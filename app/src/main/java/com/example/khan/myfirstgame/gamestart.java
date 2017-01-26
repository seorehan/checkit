package com.example.khan.myfirstgame;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by khan on 1/20/2017.
 */
public class gamestart extends Activity implements View.OnClickListener {

    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;
    Button buttonObjectChoice4;
    Button buttonObjectChoice5;
    TextView textObjectPartA;
    TextView textObjectPartB;
    TextView Sing_of_opreti;
    int correctAnswer;
    int wrongAnswer1;
    int wrongAnswer2;
    int currentlevel = 1;
    int currenrscore = 0;
    int gameover = 1;
    String givevalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamestart);
        textObjectPartA = (TextView) findViewById(R.id.textView);
        textObjectPartB = (TextView) findViewById(R.id.textView2);
        buttonObjectChoice1 = (Button) findViewById(R.id.button);
        buttonObjectChoice2 = (Button) findViewById(R.id.button2);
        buttonObjectChoice3 = (Button) findViewById(R.id.button3);
        buttonObjectChoice4 = (Button) findViewById(R.id.button4);
        buttonObjectChoice5 = (Button) findViewById(R.id.button5);
        Sing_of_opreti = (TextView) findViewById(R.id.textView3);

        task();


    }

    public void task() {
        Random randInt = new Random();
        int NumberRange = currentlevel * 3;
        int partA = randInt.nextInt(NumberRange);
        int partB = randInt.nextInt(NumberRange);
        partA++;
        partB++;
        int opertion_change = randInt.nextInt(3);
        if (opertion_change == 0) {
            correctAnswer = partA + partB;
            Sing_of_opreti.setText("+");
        }
        if (opertion_change == 1) {
            if (currentlevel > 5) {
                correctAnswer = partA - partB;
                Sing_of_opreti.setText("-");
            } else {
                correctAnswer = partA + partB;
                Sing_of_opreti.setText("+");
            }
        }
        if (opertion_change == 2) {
            if (currentlevel > 5) {
                correctAnswer = partA * partB;
                Sing_of_opreti.setText("*");
            } else {
                correctAnswer = partA + partB;
                Sing_of_opreti.setText("+");
            }
        }
        if (opertion_change == 3) {
            if (currentlevel > 5) {
                correctAnswer = partA * partB;
                Sing_of_opreti.setText("*");
            } else {
                correctAnswer = partA + partB;
                Sing_of_opreti.setText("+");
            }
        }
        // int Number2 =  randInt.nextInt(NumberRange);
        wrongAnswer1 = correctAnswer - randInt.nextInt(20);
        wrongAnswer2 = correctAnswer + randInt.nextInt(20);
        textObjectPartA.setText("" + partA);
        textObjectPartB.setText("" + partB);
        if (wrongAnswer2 == wrongAnswer1) {
            wrongAnswer2 = wrongAnswer2 + wrongAnswer1;
        }


        int case_name_button_change = randInt.nextInt(2);
        if (case_name_button_change == 0) {
            buttonObjectChoice1.setText("" + correctAnswer);
            buttonObjectChoice2.setText("" + wrongAnswer1);
            buttonObjectChoice3.setText("" + wrongAnswer2);
        }
        if (case_name_button_change == 1) {
            buttonObjectChoice1.setText("" + wrongAnswer1);
            buttonObjectChoice2.setText("" + correctAnswer);
            buttonObjectChoice3.setText("" + wrongAnswer2);
        }
        if (case_name_button_change == 2) {
            buttonObjectChoice1.setText("" + wrongAnswer1);
            buttonObjectChoice2.setText("" + wrongAnswer2);
            buttonObjectChoice3.setText("" + correctAnswer);
        }
        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);
       if(gameover >= 4){
           Intent i = new Intent(this,MainActivity.class);
           i.putExtra("key","value");
           startActivity(i);

       }

    }


    //score update section
    protected void update_score_leval(int Ansgiven) {

        currenrscore = Integer.parseInt(buttonObjectChoice4.getText().toString());
        currenrscore = currenrscore + 10;
        buttonObjectChoice4.setText("" + currenrscore);
        int check = 20;
        if (currenrscore > check) {

            // currentlevel =   Integer.parseInt(buttonObjectChoice5.getText().toString());

            currentlevel++;
            buttonObjectChoice5.setText("" + currentlevel);
            check = check + 60;
        }

    }


    //answer checking contents
    @Override
    public void onClick(View view) {
        int Ansgiven = 0;
        switch (view.getId()) {
            case R.id.button:
                Ansgiven = Integer.parseInt(buttonObjectChoice1.getText().toString());

                if (Ansgiven == correctAnswer) {
                    Toast.makeText(getApplicationContext(),
                            "Well done!",
                            Toast.LENGTH_SHORT).show();
                    task();
                    update_score_leval(Ansgiven);


                } else {
                    Toast.makeText(getApplicationContext(), "sorry", Toast.LENGTH_SHORT).show();
                    gameover = gameover + 1;
                    task();

                }
                break;
            case R.id.button2:
                Ansgiven = Integer.parseInt(buttonObjectChoice2.getText().toString());
                if (Ansgiven == correctAnswer) {
                    Toast.makeText(getApplicationContext(),
                            "Well done!",
                            Toast.LENGTH_SHORT).show();
                    task();
                    update_score_leval(Ansgiven);


                } else {
                    Toast.makeText(getApplicationContext(), "sorry", Toast.LENGTH_SHORT).show();
                    gameover++;
                    task();
                }
                break;
            case R.id.button3:
                Ansgiven = Integer.parseInt(buttonObjectChoice3.getText().toString());
                if (Ansgiven == correctAnswer) {
                    Toast.makeText(getApplicationContext(),
                            "Well done!",
                            Toast.LENGTH_SHORT).show();
                    task();
                    update_score_leval(Ansgiven);


                } else {
                    Toast.makeText(getApplicationContext(), "sorry", Toast.LENGTH_SHORT).show();
                    gameover++;
                    task();
                }
                break;
        }
    }


    public void dialogevent() {


        AlertDialog.Builder altdial = new AlertDialog.Builder(gamestart.this);
        altdial.setMessage("Do you want to Quit this app ???").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = altdial.create();
        alert.setTitle("Dialog Header");
        alert.show();


    }
}