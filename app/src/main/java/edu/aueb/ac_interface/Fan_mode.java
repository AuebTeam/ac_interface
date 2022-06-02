package edu.aueb.ac_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Fan_mode extends AppCompatActivity {

    TextView header,louver_text,air_flow_text,fan_mode_text;

    Button btnBack, btnTurnoff;

    FloatingActionButton help;

    Spinner spinner1,spinner2;

    Context context;
    Resources resources;

    String louver_string,air_flow_string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_mode);

        context = LocaleHelper.setLocale(Fan_mode.this);
        resources = context.getResources();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        header = findViewById(R.id.headtext);
        louver_text = findViewById(R.id.louver_text);
        air_flow_text = findViewById(R.id.air_flow_text);
        fan_mode_text = findViewById(R.id.fan_mode_text);

        btnBack = findViewById(R.id.back_fan);
        btnTurnoff = findViewById(R.id.turn_off_fan);

        help = findViewById(R.id.help_fan);

        spinner1 = findViewById(R.id.spinner_airflow);
        spinner2 = findViewById(R.id.spinner_louver);

        header.setText(resources.getString(R.string.header));
        louver_text.setText(resources.getString(R.string.louver));
        air_flow_text.setText(resources.getString(R.string.air_flow));
        fan_mode_text.setText(resources.getString(R.string.fan_mode));

        btnBack.setText(resources.getString(R.string.back));
        btnTurnoff.setText(resources.getString(R.string.turn_off));

        air_flow_string = resources.getString(R.string.air_medium);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(resources.getString(R.string.air_low));
        arrayList.add(resources.getString(R.string.air_medium));
        arrayList.add(resources.getString(R.string.air_high));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                air_flow_string = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> arrayListL = new ArrayList<>();
        arrayListL.add(resources.getString(R.string.low));
        arrayListL.add(resources.getString(R.string.medium));
        arrayListL.add(resources.getString(R.string.high));

        louver_string = resources.getString(R.string.low);

        ArrayAdapter<String> arrayAdapterL = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayListL);
        arrayAdapterL.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapterL);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                louver_string = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnTurnoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnTurnoff.setSelected(!btnTurnoff.isSelected());
                final int mode_int = (btnTurnoff.isSelected())?1:0;
                if (mode_int == 1) {
                    btnTurnoff.setText(resources.getString(R.string.turn_off));
                    Toast.makeText(context,"The AC has been turned on with air flow : " + air_flow_string +
                            ", louver height : " + louver_string , Toast.LENGTH_SHORT).show();
                } else {
                    btnTurnoff.setText(resources.getString(R.string.activate));
                    Toast.makeText(context,R.string.toast_deact, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Fan_mode.this, Average.class));
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle(resources.getString(R.string.help_title));
                builder.setMessage(resources.getString(R.string.help_fanmode));
                builder.setPositiveButton(resources.getString(R.string.ok), null);
                builder.show();
            }
        });


    }
}