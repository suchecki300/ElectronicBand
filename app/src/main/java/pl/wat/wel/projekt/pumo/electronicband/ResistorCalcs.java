package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ResistorCalcs extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int d1 = 0;
    int d2 = 0;
    int mnoz = 0;
    int toler = 0;
    double wynik = 0;
    double[] multiply = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 0.1, 0.01};
    String[] tolerance = {"1", "2", "0.5", "0.25", "0.1", "0.05", "5", "10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resistor_calcs);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Czarny");
        categories.add("Brązowy");
        categories.add("Czerwony");
        categories.add("Pomarańczowy");
        categories.add("Żółty");
        categories.add("Zielony");
        categories.add("Niebieski");
        categories.add("Fioletowy");
        categories.add("Szary");
        categories.add("Biały");

        List<String> categories2 = new ArrayList<String>();
        categories2.add("Czarny");
        categories2.add("Brązowy");
        categories2.add("Czerwony");
        categories2.add("Pomarańczowy");
        categories2.add("Żółty");
        categories2.add("Zielony");
        categories2.add("Niebieski");
        categories2.add("Fioletowy");
        categories2.add("Szary");
        categories2.add("Biały");
        categories2.add("Złoty");
        categories2.add("Srebrny");

        List<String> categories3 = new ArrayList<String>();
        categories3.add("Brązowy");
        categories3.add("Czerwony");
        categories3.add("Zielony");
        categories3.add("Niebieski");
        categories3.add("Fioletowy");
        categories3.add("Szary");
        categories3.add("Złoty");
        categories3.add("Srebrny");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // Spinner element
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        Button button = (Button) findViewById(R.id.res_count);

        // Spinner click listener
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);
        // attaching data adapter to spinner
        spinner1.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);
        spinner3.setAdapter(dataAdapter2);
        spinner4.setAdapter(dataAdapter3);


        spinner2.setEnabled(false);
        spinner3.setEnabled(false);
        spinner4.setEnabled(false);
        //button.setEnabled(false);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinner = (Spinner) parent;
        //Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        Button button = (Button) findViewById(R.id.res_count);

        if (spinner.getId() == R.id.spinner1) {
            d1 = position;
            spinner2.setEnabled(true);
        } else if (spinner.getId() == R.id.spinner2) {
            d2 = position;
            spinner3.setEnabled(true);
        } else if (spinner.getId() == R.id.spinner3) {
            mnoz = position;
            spinner4.setEnabled((true));
        } else if (spinner.getId() == R.id.spinner4) {
            toler = position;
            button.setEnabled(true);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void res_licz(View view) {
        //Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        Button button = (Button) findViewById(R.id.res_count);
        TextView text = (TextView) findViewById(R.id.res_wynik);

        if (spinner4.isEnabled() == true) {

            String s = Integer.toString(d1) + Integer.toString(d2);
            wynik = (Integer.parseInt(s)) * multiply[mnoz];
            String out = Double.toString(wynik) + " Ohm +/- " + tolerance[toler] + "%";
            text.setText(out);
            spinner2.setEnabled(false);
            spinner3.setEnabled(false);
            spinner4.setEnabled(false);
            //button.setEnabled(false);


        } else {
            Context context = getApplicationContext();
            CharSequence tost = "Zaznacz wszystkie wartości!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, tost, duration);
            toast.show();
        }
    }
}
