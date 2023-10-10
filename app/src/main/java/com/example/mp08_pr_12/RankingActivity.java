package com.example.mp08_pr_12;

import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class RankingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking_activity);

        TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT,1.0f);
        TableRow.LayoutParams params2=new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableLayout table = (TableLayout) findViewById(R.id.table);

        for(int i=0;i<MainActivity.records.size();i++)
        {
            Log.i("INFO", MainActivity.records.get(i).name);
            //Creating new tablerows and textviews
            TableRow row=new TableRow(RankingActivity.this);
            TextView name=new TextView(RankingActivity.this);
            TextView tries=new TextView(RankingActivity.this);

            //setting the text
            name.setText(MainActivity.records.get(i).name);
            Integer intentsStr = MainActivity.records.get(i).intents;
            tries.setText(intentsStr.toString());

            name.setLayoutParams(params1);
            tries.setLayoutParams(params1);

            //the textviews have to be added to the row created
            row.addView(name);
            row.addView(tries);

            row.setLayoutParams(params2);
            table.addView(row);
        }
    }
}


