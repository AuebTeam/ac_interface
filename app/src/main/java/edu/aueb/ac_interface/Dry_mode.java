package edu.aueb.ac_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Dry_mode extends AppCompatActivity {

    TextView header,dry_mode,humidity_text,humidity;

    Button btnBack, btnTurnoff;

    FloatingActionButton help;

    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dry_mode);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        context = LocaleHelper.setLocale(Dry_mode.this);
        resources = context.getResources();

        header = findViewById(R.id.headtext);
        dry_mode = findViewById(R.id.dry_mode_text);
        humidity_text = findViewById(R.id.humidity_text);
        humidity = findViewById(R.id.humidity_text_text);

        btnBack = findViewById(R.id.back_dry);
        btnTurnoff = findViewById(R.id.turn_off_dry);

        help = findViewById(R.id.help_dry);



        header.setText(resources.getString(R.string.header));
        dry_mode.setText(resources.getString(R.string.dry_mode));
        humidity_text.setText(resources.getString(R.string.humidity));
        humidity.setText("60 %");

        btnBack.setText(resources.getString(R.string.back));
        btnTurnoff.setText(resources.getString(R.string.activate));

        btnTurnoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnTurnoff.setSelected(!btnTurnoff.isSelected());
                final int mode_int = (btnTurnoff.isSelected())?1:0;
                if (mode_int == 1) {
                    btnTurnoff.setText(resources.getString(R.string.turn_off));
                    Toast.makeText(context,"The AC has been turned on and the humidity level is 60%", Toast.LENGTH_SHORT).show();
                } else {
                    btnTurnoff.setText(resources.getString(R.string.activate));
                    Toast.makeText(context,R.string.toast_deact, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dry_mode.this, Average.class));
            }
        });


        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle(resources.getString(R.string.help_title));
                builder.setMessage(resources.getString(R.string.help_drymode));
                builder.setPositiveButton(resources.getString(R.string.ok), null);
                builder.show();
            }
        });
    }
}