package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Damian-Ja on 2017-03-29.
 */

public class BasicTermsActivity extends AppCompatActivity {
    Context context = BasicTermsActivity.this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        //Tworzenie listy słów.
        final ArrayList<List> list = new ArrayList<>();

        //Dodanie przykładowych zmiennych do listy.
        list.add(new List("Prąd stały"));
        list.add(new List("Prąd zmienny"));
        list.add(new List("Impedancja"));
        list.add(new List("Prostowanie półokresowe"));
        list.add(new List("Prostowanie pełnookresowe"));
        list.add(new List("Napięcie przebicia"));
        list.add(new List("Moc znamionowa"));
        list.add(new List("Układ scalony"));
        list.add(new List("Liniowe układy scalone"));
        list.add(new List("Cyfrowe układy scalone"));

        //Tworzenie obiektu klasy ListAdapter.
        ListAdapter adapter = new ListAdapter(this, list);

        //Ustawianie na listView adaptera.
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    alertDialog(getString(R.string.direct_current)).create().show();
                }
                if (position == 1) {
                    alertDialog(getString(R.string.alternating_current)).create().show();
                }
                if (position == 2) {
                    alertDialog(getString(R.string.impedance)).create().show();
                }
                if (position == 3) {
                    alertDialog(getString(R.string.prostowanie_półokresowe)).create().show();
                }
                if (position == 4) {
                    alertDialog(getString(R.string.prostowanie_pełnookresowe)).create().show();
                }
                if (position == 5) {
                    alertDialog(getString(R.string.napiecie_przebicia)).create().show();
                }
                if (position == 6) {
                    alertDialog(getString(R.string.moc_znamionowa)).create().show();
                }
                if (position == 7) {
                    alertDialog(getString(R.string.uklad_scalony)).create().show();
                }
                if (position == 8) {
                    alertDialog(getString(R.string.liniowy_ukladScalony)).create().show();
                }
                if (position == 9) {
                    alertDialog(getString(R.string.cyfrowe_ukladyScalone)).create().show();
                }
            }
        });
    }

    private AlertDialog.Builder alertDialog(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = BasicTermsActivity.this.getLayoutInflater();
        View dialogView = layoutInflater.inflate(R.layout.test_layout, null);
        builder.setView(dialogView);

        TextView textView1 = (TextView) dialogView.findViewById(R.id.test_textView1);

        textView1.setText(text);

        return builder;
    }
}
