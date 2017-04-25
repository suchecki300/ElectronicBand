package pl.wat.wel.projekt.pumo.electronicband.Calcs;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pl.wat.wel.projekt.pumo.electronicband.R;

public class LogicCalcsXOR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_calcs_xor);
        Button aXor = (Button) findViewById(R.id.butAxor);
        Button bXor = (Button) findViewById(R.id.butBxor);
        TextView out = (TextView) findViewById(R.id.outQxor);
        aXor.setText("1");
        bXor.setText("0");
        Context context = getApplicationContext();
        CharSequence text = "Dotknij aby zmienic wartosci bramki";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void XorA(View view) {
        Button aXor = (Button) findViewById(R.id.butAxor);
        Button bXor = (Button) findViewById(R.id.butBxor);
        TextView out = (TextView) findViewById(R.id.outQxor);
        if (aXor.getText() == "1"){
            aXor.setText("0");
            if (bXor.getText() == "1")
                out.setText("1");
            else
                out.setText("0");
        } else {
            aXor.setText("1");
            if (bXor.getText() == "0")
                out.setText("1");
            else
                out.setText("0");
        }
    }

    public void XorB(View view) {
        Button aXor = (Button) findViewById(R.id.butAxor);
        Button bXor = (Button) findViewById(R.id.butBxor);
        TextView out = (TextView) findViewById(R.id.outQxor);
        if (bXor.getText() == "1"){
            bXor.setText("0");
            if (aXor.getText() == "1")
                out.setText("1");
            else
                out.setText("0");
        } else {
            bXor.setText("1");
            if (aXor.getText() == "0")
                out.setText("1");
            else
                out.setText("0");
        }
    }
}
