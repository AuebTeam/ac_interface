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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Experienced extends AppCompatActivity {


    FloatingActionButton help;

    Context context;
    Resources resources;

    Button back,activate;

    RadioButton turn_on,turn_off,no_timer,radioButton;

    TextView header,timer_header,mode_header;

    Spinner spinner;

    String mode,timer_mode;

    TextInputEditText timer_text;

    RadioGroup radio_group;

    int minutes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experienced);

        context = LocaleHelper.setLocale(Experienced.this);
        resources = context.getResources();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        mode = resources.getString(R.string.heat_cold_mode);
        spinner = findViewById(R.id.spinner);
        header = (TextView) findViewById(R.id.headtext);
        timer_header = (TextView) findViewById((R.id.timerview));
        mode_header = (TextView) findViewById((R.id.modeview));

        back = findViewById(R.id.back_3);
        activate = findViewById(R.id.turn_on);

        help = findViewById(R.id.experienced_help_button);

        turn_on = findViewById(R.id.turn_on_timer);
        turn_off = findViewById(R.id.turn_off_timer);
        no_timer = findViewById(R.id.no_timer);
        radio_group = findViewById(R.id.radio_group);

        timer_text = (TextInputEditText) findViewById(R.id.timer_text);

        activate.setText(resources.getString(R.string.activate));
        back.setText(resources.getString(R.string.back));
        header.setText(resources.getString(R.string.header));
        timer_header.setText(resources.getString(R.string.choose_timer));
        mode_header.setText(resources.getString(R.string.mode));
        turn_on.setText(resources.getString(R.string.turn_on_timer));
        turn_off.setText(resources.getString(R.string.turn_off_timer));
        no_timer.setText(resources.getString(R.string.no_timer));
        timer_text.setText(resources.getString(R.string.timer_message));


        timer_mode = "No Timer";
        minutes = 0;

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(resources.getString(R.string.heat_cold_mode));
        arrayList.add(resources.getString(R.string.fan_mode));
        arrayList.add(resources.getString(R.string.dry_mode));


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mode = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String temp = timer_text.getText().toString();
                if(!temp.equals("Type number of minutes") && !temp.equals("Γράψτε Αριθμό Λεπτών")) {
                    temp = temp.replace(" ","");
                    temp = temp.replace("\n","");
                    minutes = Integer.parseInt(temp);
                }
                System.out.println(timer_mode + " : " + minutes);
                if(mode.equals(resources.getString(R.string.heat_cold_mode))) {
                    startActivity(new Intent(Experienced.this, Hc_interface.class));
                }
                else if(mode.equals(resources.getString(R.string.fan_mode)))
                {
                    startActivity(new Intent(Experienced.this, Fan_mode.class));
                }
                else{
                    startActivity(new Intent(Experienced.this, Dry_mode.class));
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Experienced.this, User_proficiency.class));
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle(resources.getString(R.string.help_title));
                builder.setMessage(resources.getString(R.string.help_experienced));
                builder.setPositiveButton(resources.getString(R.string.ok), null);
                builder.show();
            }
        });



    }

    public void checkButton(View view){
        int radioId = radio_group.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        if(radioButton.equals(turn_on)){
            timer_mode = "Timer On";
        }
        else if(radioButton.equals(turn_off)){
            timer_mode = "Timer Off";
        }
        else{
            timer_mode = "No Timer";
        }
    }
}