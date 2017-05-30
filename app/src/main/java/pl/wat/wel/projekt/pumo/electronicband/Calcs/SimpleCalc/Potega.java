package pl.wat.wel.projekt.pumo.electronicband.Calcs.SimpleCalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pl.wat.wel.projekt.pumo.electronicband.R;

public class Potega extends AppCompatActivity {

    TextView number_txt;
    Button button_ok;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potega);

        button_ok = (Button) findViewById(R.id.button_ok) ;
        number_txt = (TextView) findViewById(R.id.number_txt);
        editText = (EditText) findViewById(R.id.editText) ;

        Intent intent = getIntent();
        final String message = intent.getStringExtra("funkcja");
        number_txt.setText(message);


        button_ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Wprowadź wykładnik!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent startIntent = new Intent(getApplicationContext(), Prosty_Kalkulator.class);
                    double final_number = Math.pow(Double.parseDouble(message), Double.parseDouble(editText.getText().toString()));
                    startIntent.putExtra("funkcja", Double.toString(final_number));
                    startActivity(startIntent);
                }
            }
        });
    }



}
