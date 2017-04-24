package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogicCalcsNAND extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_calcs_nand);
        Button aXor = (Button) findViewById(R.id.butAnand);
        Button bXor = (Button) findViewById(R.id.butBnand);
        TextView out = (TextView) findViewById(R.id.outQnand);
        aXor.setText("0");
        bXor.setText("0");
        Context context = getApplicationContext();
        CharSequence text = "Dotknij aby zmienic wartosci bramki";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void NandA(View view) {
        Button aXor = (Button) findViewById(R.id.butAnand);
        Button bXor = (Button) findViewById(R.id.butBnand);
        TextView out = (TextView) findViewById(R.id.outQnand);
        if (aXor.getText() == "0"){
            aXor.setText("1");
            if (bXor.getText() == "1")
                out.setText("0");
            else
                out.setText("1");
        } else {
            aXor.setText("0");
            out.setText("1");
        }
    }

    public void NandB(View view) {
        Button aXor = (Button) findViewById(R.id.butAnand);
        Button bXor = (Button) findViewById(R.id.butBnand);
        TextView out = (TextView) findViewById(R.id.outQnand);
        if (bXor.getText() == "0"){
            bXor.setText("1");
            if (aXor.getText() == "1")
                out.setText("0");
            else
                out.setText("1");
        } else {
            bXor.setText("0");
            out.setText("1");
        }
    }
}