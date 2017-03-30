package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent prosty_calc_back = getIntent();
                String strData= prosty_calc_back.getStringExtra("name");

                Toast.makeText(getApplicationContext(), moree[position] +  " (" + strData + ")", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
