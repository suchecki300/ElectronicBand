package pl.wat.wel.projekt.pumo.electronicband;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ElementyElektoniczneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        final ArrayList<List> list = new ArrayList<>();

        list.add(new List("hello"));
        list.add(new List("hello"));
        list.add(new List("hello"));
        list.add(new List("hello"));
        list.add(new List("hello"));
        list.add(new List("hello"));
        list.add(new List("hello"));
        list.add(new List("hello"));
        list.add(new List("hello"));
        list.add(new List("hello"));


        ListAdapter adapter = new ListAdapter(this,list);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
