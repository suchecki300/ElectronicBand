package pl.wat.wel.projekt.pumo.electronicband.SchematEditor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import pl.wat.wel.projekt.pumo.electronicband.R;

import static pl.wat.wel.projekt.pumo.electronicband.R.id.number_txt;

public class Saving_netlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_netlist);

        TextView textView = (TextView) findViewById(R.id.textView27);

        Intent intent = getIntent();
        final String message = intent.getStringExtra("names");
        textView.setText(message);

    }
}
