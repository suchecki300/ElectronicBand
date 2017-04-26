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
        list.add(new List(getString(R.string.resistor_tittle),R.raw.resistor));
        list.add(new List(getString(R.string.resistror_constant_tittle),R.raw.resistor_constant));
        list.add(new List(getString(R.string.resistor_changing_tittle),R.raw.rezystor_zmienny));
        list.add(new List(getString(R.string.capacitor_tittle),R.raw.capacitor));
        list.add(new List(getString(R.string.coil_tittle),R.raw.coil));
        list.add(new List(getString(R.string.potentiometer_spin_tittle),R.raw.potencjometr_obrotowy));
        list.add(new List(getString(R.string.potentiometer_slide_tittle),R.raw.potencjometr_suwakowy));
        list.add(new List(getString(R.string.potentiometer_tuneInTo_tittle),R.raw.potencjometr_dostrojczy));
        list.add(new List(getString(R.string.diode_semiconductor_tittle),R.raw.diode));
        list.add(new List(getString(R.string.diode_led_tittle),R.raw.dioda_led));
        list.add(new List(getString(R.string.transistor_npn_tittle),R.raw.tranzystor_npn));
        list.add(new List(getString(R.string.transistor_pnp_tittle),R.raw.tranzystor_pnp));
        list.add(new List(getString(R.string.transistor_jfet_tittle),R.raw.tranzystor_jfet));
        list.add(new List(getString(R.string.switch_slide_tittle),R.raw.switch_slide));
        list.add(new List(getString(R.string.switch_twostabile_tittle),R.raw.switch_twostabile));
        list.add(new List(getString(R.string.switch_cradle_tittle),R.raw.switch_cradle));
        list.add(new List(getString(R.string.switch_leaf_tittle),R.raw.switch_leaf));
        list.add(new List(getString(R.string.switch_button_tittle),R.raw.switch_click));


        adapter = new ListAdapter(this, list);

        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    alertDialog(getString(R.string.resistor_tittle),getString(R.string.resistor)).create().show();
                }
                if (position == 1) {
                    alertDialog(getString(R.string.resistror_constant_tittle),getString(R.string.resistor_permament)).create().show();
                }
                if (position == 2) {
                    alertDialog(getString(R.string.resistor_changing_tittle),getString(R.string.resistor_floating)).create().show();
                }
                if (position == 3) {
                    alertDialog(getString(R.string.capacitor_tittle),getString(R.string.capacitor)).create().show();
                }
                if (position == 4) {
                    alertDialog(getString(R.string.coil_tittle),getString(R.string.coil)).create().show();
                }
                if (position == 5) {
                    alertDialog(getString(R.string.potentiometer_spin_tittle),getString(R.string.potentiometer_spin)).create().show();
                }
                if (position == 6) {
                    alertDialog(getString(R.string.potentiometer_slide_tittle),getString(R.string.potentiometer_slide)).create().show();
                }
                if (position == 7) {
                    alertDialog(getString(R.string.potentiometer_tuneInTo_tittle),getString(R.string.potentiometer_tune_into)).create().show();
                }
                if (position == 8) {
                    alertDialog(getString(R.string.diode_semiconductor_tittle),getString(R.string.diode_semiconductor)).create().show();
                }
                if (position == 9) {
                    alertDialog(getString(R.string.diode_led_tittle),getString(R.string.diode_LED)).create().show();
                }
                if (position == 10) {
                    alertDialog(getString(R.string.transistor_npn_tittle),getString(R.string.transistor_npn)).create().show();
                }
                if (position == 11) {
                    alertDialog(getString(R.string.transistor_pnp_tittle),getString(R.string.transistor_pnp)).create().show();
                }
                if (position == 12) {
                    alertDialog(getString(R.string.transistor_jfet_tittle),getString(R.string.transistor_FET)).create().show();
                }
                if (position == 13) {
                    alertDialog(getString(R.string.switch_slide_tittle),getString(R.string.switch_slide)).create().show();
                }
                if (position == 14) {
                    alertDialog(getString(R.string.switch_twostabile_tittle),getString(R.string.switch_twostabile)).create().show();
                }
                if (position == 15) {
                    alertDialog(getString(R.string.switch_cradle_tittle),getString(R.string.switch_cradle)).create().show();
                }
                if (position == 16) {
                    alertDialog(getString(R.string.switch_leaf_tittle),getString(R.string.switch_leaf)).create().show();
                }
                if (position == 17) {
                    alertDialog(getString(R.string.switch_button_tittle),getString(R.string.switch_click)).create().show();
                }
            }
        });
    }

    private AlertDialog.Builder alertDialog(String tittle, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = ElectronicElementsActivity.this.getLayoutInflater();
        View dialogView = layoutInflater.inflate(R.layout.test_layout, null);
        builder.setView(dialogView);

        TextView textView1 = (TextView) dialogView.findViewById(R.id.dialog_allText);
        TextView textView2 = (TextView) dialogView.findViewById(R.id.dialog_tittle);
        textView2.setText(tittle);
        textView1.setText(text);

        return builder;
    }
}
