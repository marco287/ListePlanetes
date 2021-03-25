package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listView);
        Data data = new Data();
        PlaneteAdapter adapter = new PlaneteAdapter(this, data);
        listview.setAdapter(adapter);
        Button cliquer = findViewById(R.id.bouton);
        cliquer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int score = 0;
                String[] PlaneteTaille = data.getTaillePlanetes();
                for (int i = 0; i < PlaneteTaille.length; i++) {
                    View v = listview.getChildAt(i);
                    Spinner sp = v.findViewById(R.id.spinner);
                    String selectedsize = sp.getSelectedItem().toString();
                    if (selectedsize.equals(PlaneteTaille[i])) {
                        score = score + 1;

                    }
                }
                Toast.makeText(MainActivity.this, "score: " + score + "/" + PlaneteTaille.length, Toast.LENGTH_LONG).show();
            }


        });
    }
}


