package pl.wat.wel.projekt.pumo.electronicband.Calcs;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pl.wat.wel.projekt.pumo.electronicband.R;

public class LogicCalcsNOT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_calcs_not);
        Button aNot = (Button) findViewById(R.id.butAnot);
        TextView out = (TextView) findViewById(R.id.outQnot);
        aNot.setText("0");
        Context context = getApplicationContext();
        CharSequence text = "Dotknij aby zmienic wartosci bramki";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void NotA(View view) {
        Button aNot = (Button) findViewById(R.id.butAnot);
        TextView out = (TextView) findViewById(R.id.outQnot);
        if (aNot.getText() == "1"){
            aNot.setText("0");
            out.setText("1");
        } else {
            aNot.setText("1");
            out.setText("0");
        }
    }
}
