package pl.wat.wel.projekt.pumo.electronicband.TheoryListAndAdapter;

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
    /**
     * Główny konstruktor klasy.
     *
     * @param context Aktywność, w której tworzony jest obiekt.
     * @param words   ArrayList, w której przechowywane są dane.
     */
    public ListAdapter(Activity context, ArrayList<List> words) {
        super(context, 0, words);
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
        TextView text = (TextView) listItemView.findViewById(R.id.tittle_text_view);
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        List currentList = getItem(position);

        text.setText(currentList.getWordText());

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