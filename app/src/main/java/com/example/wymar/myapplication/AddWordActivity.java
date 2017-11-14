package com.example.wymar.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class AddWordActivity extends AppCompatActivity {

    public static final String FRENCH = "french";
    public static final String ENGLISH = "english";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addword);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();

                String englishWord = ((EditText) findViewById(R.id.englishword)).getText().toString();
                String frenchWord = ((EditText) findViewById(R.id.frenchword)).getText().toString();
                try {
                    //TODO: There has to be a better way than this
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(openFileOutput("dictionary", Context.MODE_APPEND)));
                    writer.write(englishWord+";");
                    writer.write(frenchWord+System.getProperty(System.lineSeparator()));
                }catch(IOException e){
                    e.printStackTrace();
                }

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
