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
public class ChipsFragment extends Fragment {


    public ChipsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list, container, false);

        //Tworzenie listy słów.
        final ArrayList<List> list = new ArrayList<>();

        //Dodanie przykładowych zmiennych do listy.
        list.add(new List(getString(R.string.gate_AND_tittle)));
        list.add(new List(getString(R.string.gate_NAND_tittle)));
        list.add(new List(getString(R.string.gate_OR_tittle)));
        list.add(new List(getString(R.string.ne555_tittle)));


        //Tworzenie obiektu klasy ListAdapter.
        ListAdapter adapter = new ListAdapter(getActivity(), list);

        //Ustawianie na listView adaptera.
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    alertDialog(getString(R.string.gate_AND_tittle), getString(R.string.gate_AND)).create().show();
                }
                if (position == 1) {
                    alertDialog(getString(R.string.gate_NAND_tittle), getString(R.string.gate_NAND)).create().show();
                }
                if (position == 2) {
                    alertDialog(getString(R.string.gate_OR_tittle), getString(R.string.gate_OR)).create().show();
                }
                if (position == 3) {
                    alertDialog(getString(R.string.ne555_tittle), getString(R.string.ne555)).create().show();
                }
            }
        });
        return rootView;
    }

    private AlertDialog.Builder alertDialog(String tittle, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();

        View dialogView = layoutInflater.inflate(R.layout.custom_dialog_alert, null);
        builder.setView(dialogView);

        TextView textView1 = (TextView) dialogView.findViewById(R.id.dialog_allText);
        TextView textView2 = (TextView) dialogView.findViewById(R.id.dialog_tittle);

        textView1.setText(text);
        textView2.setText(tittle);

        return builder;
    }
}
