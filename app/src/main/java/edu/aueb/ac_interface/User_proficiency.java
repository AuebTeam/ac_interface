package edu.aueb.ac_interface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class User_proficiency extends AppCompatActivity {

    TextView messageView;

    Button average,elder,back;
    FloatingActionButton help;
    AlertDialog.Builder builder;
    Context context;
    Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_proficiency);

        context = LocaleHelper.setLocale(User_proficiency.this);
        resources = context.getResources();

        builder = new AlertDialog.Builder(this);
        messageView = (TextView) findViewById(R.id.headtext);
        average = findViewById(R.id.experienced);
        elder = findViewById(R.id.novice);
        back = findViewById(R.id.back_1);

        help = findViewById(R.id.user_proficiency_help_button);
        average.setText(resources.getString(R.string.average));
        elder.setText(resources.getString(R.string.elder));
        back.setText(resources.getString(R.string.back));

        messageView.setText(resources.getString(R.string.header));

        average.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(User_proficiency.this, Average.class));
            }
        });

        elder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(User_proficiency.this, Elder.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(User_proficiency.this, MainActivity.class));
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setTitle(resources.getString(R.string.help_title));
                builder.setMessage(resources.getString(R.string.help_usprof));
                builder.setPositiveButton(resources.getString(R.string.ok), null);
                builder.show();
            }
        });
    }
}