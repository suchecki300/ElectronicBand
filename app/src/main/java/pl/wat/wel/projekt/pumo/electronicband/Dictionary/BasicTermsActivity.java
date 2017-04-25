package pl.wat.wel.projekt.pumo.electronicband.Dictionary;

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

import pl.wat.wel.projekt.pumo.electronicband.ListsAndAdapters.List;
import pl.wat.wel.projekt.pumo.electronicband.ListsAndAdapters.ListAdapter;
import pl.wat.wel.projekt.pumo.electronicband.R;

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
        list.add(new List(getString(R.string.direct_current_tittle)));
        list.add(new List(getString(R.string.alternating_current_title)));
        list.add(new List(getString(R.string.impedance_tittle)));
        list.add(new List(getString(R.string.prostowanie_polokresowe_tittle)));
        list.add(new List(getString(R.string.prostowanie_pelnookresowe_tittle)));
        list.add(new List(getString(R.string.napiecie_przebicia_tittle)));
        list.add(new List(getString(R.string.moc_znamionowa_tittle)));
        list.add(new List(getString(R.string.uklad_scalony_tittle)));
        list.add(new List(getString(R.string.liniowy_ukladScalony_tittle)));
        list.add(new List(getString(R.string.cyfrowy_ukladScalony_tittle)));

        //Tworzenie obiektu klasy ListAdapter.
        ListAdapter adapter = new ListAdapter(this, list);

        //Ustawianie na listView adaptera.
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    alertDialog(getString(R.string.direct_current_tittle), getString(R.string.direct_current)).create().show();
                }
                if (position == 1) {
                    alertDialog(getString(R.string.alternating_current_title), getString(R.string.alternating_current)).create().show();
                }
                if (position == 2) {
                    alertDialog(getString(R.string.impedance_tittle), getString(R.string.impedance)).create().show();
                }
                if (position == 3) {
                    alertDialog(getString(R.string.prostowanie_pelnookresowe_tittle), getString(R.string.prostowanie_półokresowe)).create().show();
                }
                if (position == 4) {
                    alertDialog(getString(R.string.prostowanie_pelnookresowe_tittle), getString(R.string.prostowanie_pełnookresowe)).create().show();
                }
                if (position == 5) {
                    alertDialog(getString(R.string.napiecie_przebicia_tittle), getString(R.string.napiecie_przebicia)).create().show();
                }
                if (position == 6) {
                    alertDialog(getString(R.string.moc_znamionowa_tittle), getString(R.string.moc_znamionowa)).create().show();
                }
                if (position == 7) {
                    alertDialog(getString(R.string.uklad_scalony_tittle), getString(R.string.uklad_scalony)).create().show();
                }
                if (position == 8) {
                    alertDialog(getString(R.string.liniowy_ukladScalony_tittle), getString(R.string.liniowy_ukladScalony)).create().show();
                }
                if (position == 9) {
                    alertDialog(getString(R.string.cyfrowy_ukladScalony_tittle), getString(R.string.cyfrowe_ukladyScalone)).create().show();
                }
            }
        });
    }

    private AlertDialog.Builder alertDialog(String tittle, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = BasicTermsActivity.this.getLayoutInflater();
        View dialogView = layoutInflater.inflate(R.layout.test_layout, null);
        builder.setView(dialogView);

        TextView textView1 = (TextView) dialogView.findViewById(R.id.dialog_allText);
        TextView textView2 = (TextView) dialogView.findViewById(R.id.dialog_tittle);
        textView1.setText(text);
        textView2.setText(tittle);

        return builder;
    }
}
