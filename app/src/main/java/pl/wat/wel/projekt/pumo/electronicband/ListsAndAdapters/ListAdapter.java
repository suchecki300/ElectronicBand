package pl.wat.wel.projekt.pumo.electronicband.ListsAndAdapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pl.wat.wel.projekt.pumo.electronicband.R;

/**
 * Created by Damian-Ja on 2017-03-29.
 */


public class ListAdapter extends ArrayAdapter<List> {
    private Activity mContext;

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


        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        tekst.setText(currentList.getWordText());

        if (currentList.hasImage()) {
            image.setImageResource(currentList.getPictureID());
            image.setVisibility(View.VISIBLE);
            image.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));

        } else {
            image.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
