package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogicCalcsNOR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_calcs_nor);
        Button aNor = (Button) findViewById(R.id.butAnor);
        Button bNor = (Button) findViewById(R.id.butBnor);
        TextView out = (TextView) findViewById(R.id.outQnor);
        aNor.setText("0");
        bNor.setText("0");
        Context context = getApplicationContext();
        CharSequence text = "Dotknij aby zmienic wartosci bramki";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void NorA(View view) {
        Button aNor = (Button) findViewById(R.id.butAnor);
        Button bNor = (Button) findViewById(R.id.butBnor);
        TextView out = (TextView) findViewById(R.id.outQnor);
        if (aNor.getText() == "1"){
            aNor.setText("0");
            if (bNor.getText()=="0"){
                out.setText("1");
            } else {
                out.setText("0");
            }
        } else {
            aNor.setText("1");
            out.setText("0");
        }
    }

    public void NorB(View view) {
        Button aNor = (Button) findViewById(R.id.butAnor);
        Button bNor = (Button) findViewById(R.id.butBnor);
        TextView out = (TextView) findViewById(R.id.outQnor);
        if (bNor.getText() == "1"){
            bNor.setText("0");
            if (aNor.getText()=="0"){
                out.setText("1");
            } else {
                out.setText("0");
            }
        } else {
            bNor.setText("1");
            out.setText("0");
        }
    }


}
