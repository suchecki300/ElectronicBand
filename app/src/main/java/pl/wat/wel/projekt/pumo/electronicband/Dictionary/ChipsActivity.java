package pl.wat.wel.projekt.pumo.electronicband.Dictionary;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import pl.wat.wel.projekt.pumo.electronicband.ListsAndAdapters.List;
import pl.wat.wel.projekt.pumo.electronicband.ListsAndAdapters.ListAdapter;
import pl.wat.wel.projekt.pumo.electronicband.R;

public class ChipsActivity extends AppCompatActivity {


    Context context = ChipsActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        //Tworzenie listy słów.
        final ArrayList<List> list = new ArrayList<>();

        //Dodanie przykładowych zmiennych do listy.
        list.add(new List(getString(R.string.gate_AND_tittle)));
        list.add(new List(getString(R.string.gate_NAND_tittle)));
        list.add(new List(getString(R.string.gate_OR_tittle)));
        list.add(new List(getString(R.string.ne555_tittle)));


        //Tworzenie obiektu klasy ListAdapter.
        ListAdapter adapter = new ListAdapter(this, list);

        //Ustawianie na listView adaptera.
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    alertDialog(getString(R.string.gate_AND_tittle),getString(R.string.gate_AND)).create().show();
                }
                if (position == 1) {
                    alertDialog(getString(R.string.gate_NAND_tittle),getString(R.string.gate_NAND)).create().show();
                }
                if (position == 2) {
                    alertDialog(getString(R.string.gate_OR_tittle),getString(R.string.gate_OR)).create().show();
                }
                if (position == 3) {
                    alertDialog(getString(R.string.ne555_tittle),getString(R.string.ne555)).create().show();
                }
            }
        });
    }

    private AlertDialog.Builder alertDialog(String tittle, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = ChipsActivity.this.getLayoutInflater();

        View dialogView = layoutInflater.inflate(R.layout.test_layout, null);
        builder.setView(dialogView);

        TextView textView1 = (TextView) dialogView.findViewById(R.id.dialog_allText);
        TextView textView2 = (TextView) dialogView.findViewById(R.id.dialog_tittle);

        textView1.setText(text);
        textView2.setText(tittle);

        return builder;
    }
}