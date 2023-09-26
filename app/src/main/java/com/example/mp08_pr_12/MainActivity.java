package com.example.mp08_pr_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static int randNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Random rand = new Random();
        randNum = rand.nextInt(99)+1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText input = (EditText) findViewById(R.id.editTextNumber);
                // Do something in response to button click
                String text = "";
                if(Integer.parseInt(input.getText().toString()) == randNum){

                }else if(Integer.parseInt(input.getText().toString()) < randNum){
                    Toast toast = Toast.makeText(MainActivity.this, "El número es més gran (" + randNum+")", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(MainActivity.this, "El número es més petit (" + randNum+")", Toast.LENGTH_SHORT);
                    toast.show();
                }



            }
        });
    }
}