package pl.wat.wel.projekt.pumo.electronicband.Calcs;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pl.wat.wel.projekt.pumo.electronicband.R;

public class LogicCalcsOR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_calcs_or);
        Button aOr = (Button) findViewById(R.id.butAor);
        Button bOr = (Button) findViewById(R.id.butBor);
        TextView out = (TextView) findViewById(R.id.outQor);
        aOr.setText("1");
        bOr.setText("1");
        Context context = getApplicationContext();
        CharSequence text = "Dotknij aby zmienic wartosci bramki";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void OrA(View view) {
        Button aOr = (Button) findViewById(R.id.butAor);
        Button bOr = (Button) findViewById(R.id.butBor);
        TextView out = (TextView) findViewById(R.id.outQor);

        if (aOr.getText() == "1"){
            aOr.setText("0");
            if (bOr.getText() == "0"){
                out.setText("0");
            } else {
                out.setText("1");
            }} else {
            aOr.setText("1");
            out.setText("1");
        }
    }

    public void OrB(View view) {
        Button aOr = (Button) findViewById(R.id.butAor);
        Button bOr = (Button) findViewById(R.id.butBor);
        TextView out = (TextView) findViewById(R.id.outQor);

        if (bOr.getText() == "1"){
            bOr.setText("0");
            if (aOr.getText() == "0"){
                out.setText("0");
            } else {
                out.setText("1");
            }} else {
            bOr.setText("1");
            out.setText("1");
        }
    }


}