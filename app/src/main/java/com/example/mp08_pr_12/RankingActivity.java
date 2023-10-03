package com.example.mp08_pr_12;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class RankingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking_activity);

        TextView hallOfFame = (TextView) findViewById(R.id.hallOfFame);
        String text = "";
        MainActivity.records.sort(new CompIntents());
        for (Record record : MainActivity.records) {
            text += record.name + ": " + record.intents +"\n";
        }
        hallOfFame.setText(text);

    }
}


