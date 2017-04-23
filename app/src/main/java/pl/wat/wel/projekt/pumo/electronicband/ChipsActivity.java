package pl.wat.wel.projekt.pumo.electronicband;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ChipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        //Tworzenie listy słów.
        final ArrayList<List> list = new ArrayList<>();

        //Dodanie przykładowych zmiennych do listy.
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
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));
        list.add(new List("TEST TEST TEST TEST"));


        //Tworzenie obiektu klasy ListAdapter.
        ListAdapter adapter = new ListAdapter(this, list);

        //Ustawianie na listView adaptera.
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
