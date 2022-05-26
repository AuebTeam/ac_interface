package edu.aueb.ac_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView messageView;
    ImageButton btnGreek, btnEnglish;
    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // referencing the text and button views
        messageView = (TextView) findViewById(R.id.textView);
        btnGreek = findViewById(R.id.btnGreek);
        btnEnglish = findViewById(R.id.btnEnglish);

        // setting up on click listener event over the button
        // in order to change the language with the help of
        // LocaleHelper class
        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = LocaleHelper.setLocale(MainActivity.this, "en");
                resources = context.getResources();
                messageView.setText(resources.getString(R.string.language));
            }
        });

        btnGreek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = LocaleHelper.setLocale(MainActivity.this, "el");
                resources = context.getResources();
                messageView.setText(resources.getString(R.string.language));
            }
        });

    }
}