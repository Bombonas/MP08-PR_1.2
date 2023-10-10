package com.example.mp08_pr_12;

import java.util.Comparator;

public class Record {
    public String name;
    public int intents;

    public String temps;

    public Record(String name, int intents){
        this.name = name;
        this.intents = intents;
    }
}
class CompIntents implements Comparator<Record> {
    @Override
    public int compare(Record p1, Record p2) {
        // TODO Auto-generated method stub
        return  p1.intents - p2.intents;
    }
}

