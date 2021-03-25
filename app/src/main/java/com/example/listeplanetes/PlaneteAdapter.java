package com.example.listeplanetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.listeplanetes.Data;
import com.example.listeplanetes.MainActivity;
import com.example.listeplanetes.R;

import java.sql.Array;

public class PlaneteAdapter extends BaseAdapter {
    private final MainActivity activity;
    private Data data;
    Button button;
    int compteur;


    public PlaneteAdapter(MainActivity activity, Data data) {
        this.activity = activity;
        this.data=data;
    }

    @Override
    public int getCount() {
        return data.getPlanetes().size();
    }

    @Override
    public Object getItem(int arg0) {
        return data.getPlanetes().get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }

        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);

        nomPlanete.setText(data.getPlanetes().get(position));

        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, data.getTaillePlanetes());
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);



        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox)  compoundButton.findViewById(R.id.checkbox);
                spinner.setEnabled(!checkBox.isChecked());
                spinadapter.notifyDataSetChanged();
                if (checkBox.isChecked()) {
                    spinner.setEnabled(false);
                    spinadapter.notifyDataSetChanged();
                    compteur++;
                } else {
                    spinner.setEnabled(true);
                    spinadapter.notifyDataSetChanged();
                    compteur--;
                }
                if(compteur==data.getPlanetes().size())
                {
                    button = activity.findViewById(R.id.bouton);
                    button.setEnabled(true);

                }
                else
                {
                    button = activity.findViewById(R.id.bouton);
                    button.setEnabled(false);
                }

            }
        });

        return itemView;

    }

}

