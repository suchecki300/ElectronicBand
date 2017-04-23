package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LogicCalcsOR extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_calcs_or);
        Context context = getApplicationContext();
        CharSequence text = "Dotknij aby ustawic wartosci startowe";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void OrB(View view) {
        Button aOr = (Button) findViewById(R.id.butAor);
        Button bOr = (Button) findViewById(R.id.butBor);
        TextView out = (TextView) findViewById(R.id.outQor);
    }

    public void OrA(View view) {
    }
}
