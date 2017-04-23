package pl.wat.wel.projekt.pumo.electronicband;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ElectronicElementsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        //Tworzenie nowej listy
        final ArrayList<List> list = new ArrayList<>();

        //Dodwanie przykładowych danych
        list.add(new List("Rezystor"));
        list.add(new List("Kondensator"));
        list.add(new List("Cewka"));
        list.add(new List("Potencjometr"));
        list.add(new List("Trymer"));
        list.add(new List("Transformmator"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));



        ListAdapter adapter = new ListAdapter(this,list);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
