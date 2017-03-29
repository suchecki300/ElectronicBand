package pl.wat.wel.projekt.pumo.electronicband;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class UkladyScaloneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("UkladyScalone","Wszedlem");
        setContentView(R.layout.list);
        Log.i("UkladyScalone","Jestem po ustawieniu kontentu");
        final ArrayList<List> list = new ArrayList<>();

        list.add(new List("sdasdad"));
        list.add(new List("asdasdads"));
        list.add(new List("asasdasd"));
        list.add(new List("asdasd"));
        list.add(new List("asasdassad"));
        list.add(new List("sdasdad"));
        list.add(new List("asdasdads"));
        list.add(new List("asasdasd"));
        list.add(new List("asdasd"));
        list.add(new List("asasdassad"));

        Log.i("UkladyScalone","Jestem po wpisaniu do listy danych");
        ListAdapter adapter = new ListAdapter(this,list);
        Log.i("UkladyScalone","Ustawiam widok....");
        ListView listView = (ListView) findViewById(R.id.list);
        Log.i("UkladyScalone","Ustawilem widok, wlaczam adapter");
        listView.setAdapter(adapter);
        Log.i("UkladyScalone","OK!!!!!!");
    }
}
