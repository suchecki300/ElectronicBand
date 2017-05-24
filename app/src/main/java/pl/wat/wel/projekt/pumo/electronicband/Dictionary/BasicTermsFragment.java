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
public class BasicTermsFragment extends Fragment {
    public BasicTermsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list, container, false);

        //Tworzenie listy słów.
        final ArrayList<List> list = new ArrayList<>();

        //Dodanie przykładowych zmiennych do listy.
        list.add(new List(getString(R.string.direct_current_tittle), R.raw.dc));
        list.add(new List(getString(R.string.alternating_current_title), R.raw.ac));
        list.add(new List(getString(R.string.impedance_tittle), R.raw.impedance));
        list.add(new List(getString(R.string.prostowanie_polokresowe_tittle), R.raw.jednopolowkowy));
        list.add(new List(getString(R.string.prostowanie_pelnookresowe_tittle), R.raw.dwupolowkowy));
        list.add(new List(getString(R.string.napiecie_przebicia_tittle), R.raw.napiecie_przebicia));
        list.add(new List(getString(R.string.moc_znamionowa_tittle), R.raw.moc_znamionowa));
        list.add(new List(getString(R.string.uklad_scalony_tittle), R.raw.chip));
        list.add(new List(getString(R.string.liniowy_ukladScalony_tittle), R.raw.liniowy_uklad_scalony));
        list.add(new List(getString(R.string.cyfrowy_ukladScalony_tittle), R.raw.cyfrowy_uklad_scalony));

        //Tworzenie obiektu klasy ListAdapter.
        ListAdapter adapter = new ListAdapter(getActivity(), list);

        //Ustawianie na listView adaptera.
        ListView listView = (ListView) rootView.findViewById(R.id.list);
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
        return rootView;
    }

    private AlertDialog.Builder alertDialog(String tittle, String text) {
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
