package pl.wat.wel.projekt.pumo.electronicband.Calcs;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.lang.Math;
import pl.wat.wel.projekt.pumo.electronicband.R;

import static pl.wat.wel.projekt.pumo.electronicband.R.string.sin;

public class More_Activity_moreee extends AppCompatActivity {
    //Deklaracja zmiennych
    ListView list;
    String[] moree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_);

        Resources resources = getResources();

        moree = resources.getStringArray(R.array.more_array);

        //obsługa listy
        list= (ListView) findViewById(R.id.listView1);
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, moree));

        //Click on item :)


        Intent intent = getIntent();
        final String number = intent.getStringExtra("number");
       // Toast.makeText(getApplicationContext(), number, Toast.LENGTH_SHORT).show();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent prosty_calc_back = getIntent();
                String strData= prosty_calc_back.getStringExtra("name");

                Toast.makeText(getApplicationContext(), moree[position] +  " (" + number + ")", Toast.LENGTH_SHORT).show();

                if(moree[position].equals("sinus"))
                {
                   Intent startIntent = new Intent (getApplicationContext(),Prosty_Kalkulator.class);
                    double final_number = Math.sin(Double.parseDouble(number));
                    startIntent.putExtra("funkcja", Double.toString(final_number));
                    startActivity(startIntent);
                }
                else if(moree[position].equals("cosinus"))
                {
                    Intent startIntent = new Intent (getApplicationContext(),Prosty_Kalkulator.class);
                    double final_number = Math.cos(Double.parseDouble(number));
                    startIntent.putExtra("funkcja", Double.toString(final_number));
                    startActivity(startIntent);
                }
                else if(moree[position].equals("tangens"))
                {
                    Intent startIntent = new Intent (getApplicationContext(),Prosty_Kalkulator.class);
                    double final_number = Math.tan(Double.parseDouble(number));
                    startIntent.putExtra("funkcja", Double.toString(final_number));
                    startActivity(startIntent);
                }
                else if(moree[position].equals("logarytm naturalny"))
                {
                    Intent startIntent = new Intent (getApplicationContext(),Prosty_Kalkulator.class);
                    double final_number = Math.log(Double.parseDouble(number));
                    startIntent.putExtra("funkcja", Double.toString(final_number));
                    startActivity(startIntent);
                }
                else if(moree[position].equals("logarytm dziesiętny"))
                {
                    Intent startIntent = new Intent (getApplicationContext(),Prosty_Kalkulator.class);
                    double final_number = Math.log10(Double.parseDouble(number));
                    startIntent.putExtra("funkcja", Double.toString(final_number));
                    startActivity(startIntent);
                }
                else if(moree[position].equals("do radianów"))
                {
                    Intent startIntent = new Intent (getApplicationContext(),Prosty_Kalkulator.class);
                    double final_number = Math.toRadians(Double.parseDouble(number));
                    startIntent.putExtra("funkcja", Double.toString(final_number));
                    startActivity(startIntent);
                }
                else if(moree[position].equals("potęga"))
                {
                    Intent startIntent = new Intent (getApplicationContext(),Potega.class);
                    double final_number = Double.parseDouble(number);
                    startIntent.putExtra("funkcja", Double.toString(final_number));
                    startActivity(startIntent);
                }
            }
        });


    }
}
