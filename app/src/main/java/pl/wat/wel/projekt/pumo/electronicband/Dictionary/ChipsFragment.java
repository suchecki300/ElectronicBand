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

        final ArrayList<List> list = new ArrayList<>();

        list.add(new List(getString(R.string.gate_AND_tittle)));
        list.add(new List(getString(R.string.gate_NAND_tittle)));
        list.add(new List(getString(R.string.gate_OR_tittle)));
        list.add(new List(getString(R.string.gate_NOR_tittle)));
        list.add(new List(getString(R.string.gate_XOR_tittle)));
        list.add(new List(getString(R.string.gate_XNOR_tittle)));

        ListAdapter adapter = new ListAdapter(getActivity(), list);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    displayInfoAboutGate(getString(R.string.gate_AND_tittle), getString(R.string.gate_AND)).create().show();
                }
                if (position == 1) {
                    displayInfoAboutGate(getString(R.string.gate_NAND_tittle), getString(R.string.gate_NAND)).create().show();
                }
                if (position == 2) {
                    displayInfoAboutGate(getString(R.string.gate_OR_tittle), getString(R.string.gate_OR)).create().show();
                }
                if (position == 3) {
                    displayInfoAboutGate(getString(R.string.gate_NOR_tittle), getString(R.string.gate_NOR)).create().show();
                }
                if (position == 4) {
                    displayInfoAboutGate(getString(R.string.gate_XOR_tittle), getString(R.string.gate_XOR)).create().show();
                }
                if (position == 5) {
                    displayInfoAboutGate(getString(R.string.gate_XNOR_tittle), getString(R.string.gate_XNOR)).create().show();
                }
            }
        });
        return rootView;
    }

    private AlertDialog.Builder displayInfoAboutGate(String tittle, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View dialogView = layoutInflater.inflate(R.layout.theory_info_dialog_alert, null);
        builder.setView(dialogView);

        TextView textView1 = (TextView) dialogView.findViewById(R.id.dialog_allText);
        TextView textView2 = (TextView) dialogView.findViewById(R.id.dialog_tittle);
        textView1.setText(text);
        textView2.setText(tittle);

        return builder;
    }
}
