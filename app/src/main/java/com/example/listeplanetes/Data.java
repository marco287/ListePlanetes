package com.example.listeplanetes;

import android.widget.ArrayAdapter;

import com.example.listeplanetes.MainActivity;

import java.util.ArrayList;

public class Data {
    private ArrayList<String> planetes;
    private void installePlanetes() {
        planetes = new ArrayList<String>();
        planetes.add("Mercure");
        planetes.add("Venus");
        planetes.add("Terre");
        planetes.add("Mars");
        planetes.add("Jupiter");
        planetes.add("Saturne");
        planetes.add("Uranus");
        planetes.add("Neptune");
        planetes.add("Pluton");
    }
    //  installer l'adaptateur pour la liste déroulante (spinner)
    private String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};

    public ArrayList<String> getPlanetes() {
        return planetes;
    }

    public String[] getTaillePlanetes() {
        return taillePlanetes;
    }

    public Data(){ installePlanetes();}
}
