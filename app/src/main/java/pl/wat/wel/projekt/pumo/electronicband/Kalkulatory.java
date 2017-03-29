package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Kalkulatory extends AppCompatActivity {
    Button prosty;
    Button logiczne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulatory);

        prosty = (Button) findViewById(R.id.prosty_k);
        logiczne = (Button) findViewById(R.id.bramki_k);


        prosty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), Prosty_Kalkulator.class);
                startActivity(intent);
            }
        });


        logiczne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent (getApplicationContext(), Prosty_Kalkulator.class);
            }
        });

    }
}
