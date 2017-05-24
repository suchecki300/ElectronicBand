package pl.wat.wel.projekt.pumo.electronicband.Calcs;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pl.wat.wel.projekt.pumo.electronicband.R;

public class LogicCalcsAND extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_calcs_and);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button aAnd = (Button) findViewById(R.id.butAand);
        Button bAnd = (Button) findViewById(R.id.butBand);
        TextView out = (TextView) findViewById(R.id.outQand);
        aAnd.setText("1");
        bAnd.setText("1");
        Context context = getApplicationContext();
        CharSequence text = "Dotknij aby zmienic wartosci bramki";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void AndA(View view) {
        Button aAnd = (Button) findViewById(R.id.butAand);
        Button bAnd = (Button) findViewById(R.id.butBand);
        TextView out = (TextView) findViewById(R.id.outQand);
        if ( aAnd.getText() == "1"){
            aAnd.setText("0");
            out.setText("0");

        }
        else {
            aAnd.setText("1");
            if (bAnd.getText() == "1"){
                out.setText("1");
            }
            else {
                out.setText("0");
            }
        }
    }

    public void AndB(View view) {
        Button aAnd = (Button) findViewById(R.id.butAand);
        Button bAnd = (Button) findViewById(R.id.butBand);
        TextView out = (TextView) findViewById(R.id.outQand);
        if ( bAnd.getText() == "1"){
            bAnd.setText("0");
            out.setText("0");

        }
        else {
            bAnd.setText("1");
            if (aAnd.getText() == "1"){
                out.setText("1");
            }
            else {
                out.setText("0");
            }
        }
    }
}
