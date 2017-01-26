package com.example.khan.myfirstgame;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;


import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener {

    Button b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.button);
        b.setOnClickListener(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            //The key argument here must match that used in the other activity
            dialogevent();
        }
    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,gamestart.class);
        startActivity(i);
    }
    public void dialogevent() {

        AlertDialog.Builder altdial = new AlertDialog.Builder(MainActivity.this);
        altdial.setMessage("Do you want to Play Again ???").setCancelable(false)

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });

        AlertDialog alert = altdial.create();
        alert.setTitle("GAME OVER");
        alert.show();


    }

}
