package com.example.wymar.myapplication;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    //TODO: replace with enum?
    private String language = "english";
    private File dict;
    //ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dict = new File(getApplicationContext().getFilesDir(),"dictionary");

        //TODO:literally can't do anything until this stops returning null
        final ActionBar tabs = getActionBar();
        tabs.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener listener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

            }
        };

        /*for(char c='A';c<='Z';c++){
            tabs.addTab(tabs.newTab()
                    .setText(Character.toString(c))
                    .setTabListener(listener)
                    );
        }*/

        /*
        list = (ListView) findViewById(R.id.wordlist);

        //TODO:Replace with data from internal storage
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("dictionary")));
            String line;
            while((line =  reader.readLine()) != null){
                newList.add(line.substring(0,line.indexOf(";")));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        newList.add("A");
        Collections.sort(newList);
        list.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,newList));
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.addWord){
            addWord();
        }else if (id == R.id.switchLanguage){
            switchLanguage();
        }

        return super.onOptionsItemSelected(item);
    }

    private void addWord(){
        Intent intent = new Intent(this, AddWordActivity.class);
        startActivityForResult(intent, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            //New word should have been added to dictionary, update list.
            //list.invalidate();
        }
    }

    private void switchLanguage(){
        language = (language=="english")?"french":"english";
    }
}
