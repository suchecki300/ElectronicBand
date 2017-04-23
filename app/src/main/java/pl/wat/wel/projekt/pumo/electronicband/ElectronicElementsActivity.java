package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ElectronicElementsActivity extends AppCompatActivity {

    ArrayList<List> list;
    ListView listView;
    ListAdapter adapter;
    Context context = ElectronicElementsActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        //Tworzenie nowej listy
        list = new ArrayList<>();

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



        adapter = new ListAdapter(this, list);

        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    alertDialog("hehe hehe hehe hehe hahe  ").create().show();
                }
                if (position == 1) {
                    alertDialog("addsdsd sssd dds ddds ds ddd ").create().show();
                }
                if (position == 2) {
                    alertDialog("blabla bla bal bal blabla bla bal bal blabla bla bal bal ").create().show();
                }
            }
        });
    }

    private AlertDialog.Builder alertDialog(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = ElectronicElementsActivity.this.getLayoutInflater();
        View dialogView = layoutInflater.inflate(R.layout.test_layout, null);
        builder.setView(dialogView);

        TextView textView1 = (TextView) dialogView.findViewById(R.id.test_textView1);

        textView1.setText(text);

        return builder;
    }
}
