package com.example.user2.stringarrayautocomplete;

/*
In this example taking array of strings and showing these strings as Auto suggestions for TextView.
After AutoComplete value selection showing selected value in alert.

AutoCompleteTextView is an editable text view that shows suggestions automatically while the user is entering characters.
The list of suggestions is displayed from which the user can choose an item.
- Taking suggestion strings in an array name item.
- Taking AutoCompleteTextView reference from auto_complete_string.xml file.
- Adding item array to adapter and add adapter to AutoCompleteTextView.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    //Initialize variables
    AutoCompleteTextView autoCompleteTextView = null;
    private ArrayAdapter<String> arrayAdapter;

    //values to show in autocomplete
    String items[] ={
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
    };

    //called when activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize autocomplete values
        // get autocomplete reference from xml
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.months);

        //create Adapter
        arrayAdapter = new  ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, items);

        autoCompleteTextView.setThreshold(1);

        //set adapter to autocomplete
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnItemSelectedListener(this);
        autoCompleteTextView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this, "Position : " + position + " Month" + parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }


}
