package com.example.mp08_pr_12;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static int randNum;
    private static int cont;

    public static ArrayList<Record> records;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        records = new ArrayList<Record>();
        records.add(new Record("Pablo", 1));
        records.add(new Record("Pablon't", 1007));
        records.add(new Record("Carlos", 7));
        Random rand = new Random();
        cont = 0;
        randNum = rand.nextInt(99)+1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView intents = (TextView) findViewById(R.id.textView);
        TextView registre = (TextView) findViewById(R.id.textView2);
        Button button = (Button) findViewById(R.id.button);
        intents.setText("Intents: " + cont);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String auxRegistre = registre.getText().toString();

                EditText input = (EditText) findViewById(R.id.editTextNumber);
                // Do something in response to button click
                String text = "";
                if(!input.getText().toString().equals("")) {
                    ++cont;
                    intents.setText("Intents: " + cont);
                    if (Integer.parseInt(input.getText().toString()) == randNum) {
                        AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
                        msg.setMessage("Has guanyat :D");

                        // Set an EditText view to get user input
                        final EditText inputName = new EditText(MainActivity.this);
                        msg.setView(inputName);
                        msg.setNegativeButton("Ranking", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(MainActivity.this, RankingActivity.class);
                                if(!inputName.getText().toString().equals("")){
                                    records.add(new Record(inputName.getText().toString(), cont));
                                }else{
                                    records.add(new Record("NoName", cont));
                                }
                                startActivity(intent);
                            }
                        });
                        msg.setPositiveButton("Tornar a jugar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                                intents.setText("Intents: 0");
                                cont = 0;
                                registre.setText("");
                                randNum = rand.nextInt(99) + 1;
                                dialog.dismiss();
                            }
                        });
                        AlertDialog dialog = msg.create();
                        dialog.show();

                    } else if (Integer.parseInt(input.getText().toString()) < randNum) {
                        Toast toast = Toast.makeText(MainActivity.this, "El número es més gran (" + randNum + ")", Toast.LENGTH_SHORT);
                        toast.show();
                        auxRegistre += "X >";
                    } else {
                        Toast toast = Toast.makeText(MainActivity.this, "El número es més petit (" + randNum + ")", Toast.LENGTH_SHORT);
                        toast.show();
                        auxRegistre += "X <";
                    }
                    auxRegistre += input.getText() + "\n";
                    registre.setText(auxRegistre);

                    input.setText("");
                }
            }
        });
    }
}