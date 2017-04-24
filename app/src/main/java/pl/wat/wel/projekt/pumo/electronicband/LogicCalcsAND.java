package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogicCalcsAND extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_calcs_and);
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
