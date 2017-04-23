package pl.wat.wel.projekt.pumo.electronicband;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Damian-Ja on 2017-03-29.
 */


public class ListAdapter extends ArrayAdapter<List> {
    //===========================  Zmienne wykorzystywane w danej klasie. ==========================

    // Zmienna przetrzymuje wartość kontekstu przekazaną przez konstruktor, potrzebna do kolejnego ficzera.
    private Activity mContext;


    //==============================================================================================

    /**
     * Główny konstruktor klasy.
     *
     * @param context Aktywność, w której tworzony jest obiekt.
     * @param words   ArrayList, w której przechowywane są dane.
     */
    public ListAdapter(Activity context, ArrayList<List> words) {
        super(context, 0, words);
        this.mContext = context;
    }

    /**
     * Metoda nadpisana z klasy ArrayAdapetr.
     * Przy pomocy tej metody zostają wyświetlone poszczególne dane ze zbioru.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }
        List currentList = getItem(position);

        TextView tekst = (TextView) listItemView.findViewById(R.id.text_view_1);
        tekst.setText(currentList.getWordText());

        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.text_container);
        linearLayout.setBackgroundColor(mContext.getResources().getColor(R.color.listColor));

        return listItemView;
    }
}
