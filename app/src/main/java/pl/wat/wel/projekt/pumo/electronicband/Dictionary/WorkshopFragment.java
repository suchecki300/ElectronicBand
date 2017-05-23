package pl.wat.wel.projekt.pumo.electronicband.Dictionary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import pl.wat.wel.projekt.pumo.electronicband.ListsAndAdapters.List;
import pl.wat.wel.projekt.pumo.electronicband.ListsAndAdapters.ListAdapter;
import pl.wat.wel.projekt.pumo.electronicband.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkshopFragment extends Fragment {
    public WorkshopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list, container, false);

        //Tworzenie listy słów.
        final ArrayList<List> list = new ArrayList<>();

        //Dodanie przykładowych zmiennych do listy.
        list.add(new List(getString(R.string.soldering_tittle)));
        list.add(new List(getString(R.string.solder_tittle)));
        list.add(new List(getString(R.string.base_solder_tittle)));
        list.add(new List(getString(R.string.metalic_solder_tittle)));
        list.add(new List(getString(R.string.sponge_tittle)));
        list.add(new List(getString(R.string.paste_tittle)));
        list.add(new List(getString(R.string.hoover_cin_tittle)));
        list.add(new List(getString(R.string.pincers_tittle)));
        list.add(new List(getString(R.string.crib_isolator_tittle)));
        list.add(new List(getString(R.string.third_hand_tittle)));
        list.add(new List(getString(R.string.heighten_glass_tittle)));
        list.add(new List(getString(R.string.protection_glasses_tittle)));
        list.add(new List(getString(R.string.antistatic_hand_belt_tittle)));
        list.add(new List(getString(R.string.table_contact_tittle)));

        //Tworzenie obiektu klasy ListAdapter.
        ListAdapter adapter = new ListAdapter(getActivity(), list);

        //Ustawianie na listView adaptera.
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    alertDialog(getString(R.string.soldering_tittle), getString(R.string.soldering_description)).create().show();
                }
                if (position == 1) {
                    alertDialog(getString(R.string.solder_tittle), getString(R.string.solder_description)).create().show();
                }
                if (position == 2) {
                    alertDialog(getString(R.string.base_solder_tittle), getString(R.string.base_solder_description)).create().show();
                }
                if (position == 3) {
                    alertDialog(getString(R.string.metalic_solder_tittle), getString(R.string.metalic_solder_description)).create().show();
                }
                if (position == 4) {
                    alertDialog(getString(R.string.sponge_tittle), getString(R.string.sponge_description)).create().show();
                }
                if (position == 5) {
                    alertDialog(getString(R.string.paste_tittle), getString(R.string.paste_description)).create().show();
                }
                if (position == 6) {
                    alertDialog(getString(R.string.hoover_cin_tittle), getString(R.string.hoover_cin_description)).create().show();
                }
                if (position == 7) {
                    alertDialog(getString(R.string.pincers_tittle), getString(R.string.pincers_description)).create().show();
                }
                if (position == 8) {
                    alertDialog(getString(R.string.crib_isolator_tittle), getString(R.string.crib_isolator_description)).create().show();
                }
                if (position == 9) {
                    alertDialog(getString(R.string.third_hand_tittle), getString(R.string.third_hand_description)).create().show();
                }
                if (position == 10) {
                    alertDialog(getString(R.string.heighten_glass_tittle), getString(R.string.heighten_glass_description)).create().show();
                }
                if (position == 11) {
                    alertDialog(getString(R.string.protection_glasses_tittle), getString(R.string.protection_glasses_description)).create().show();
                }
                if (position == 12) {
                    alertDialog(getString(R.string.antistatic_hand_belt_tittle), getString(R.string.antistatic_hand_belt_description)).create().show();
                }
                if (position == 13) {
                    alertDialog(getString(R.string.table_contact_tittle), getString(R.string.table_contact_description)).create().show();
                }
            }
        });
        return rootView;
    }

    private AlertDialog.Builder alertDialog(String tittle, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View dialogView = layoutInflater.inflate(R.layout.theory_info_dialog_alert, null);
        builder.setView(dialogView);

        TextView textView1 = (TextView) dialogView.findViewById(R.id.dialog_allText);
        TextView textView2 = (TextView) dialogView.findViewById(R.id.dialog_tittle);
        textView2.setText(tittle);
        textView1.setText(text);

        return builder;
    }
}
