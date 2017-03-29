package pl.wat.wel.projekt.pumo.electronicband;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

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
                Button logiczne = (Button) findViewById(R.id.bramki_k);
                LinearLayout logic_sub = (LinearLayout) findViewById(R.id.logic_submenu);
                if ( logic_sub.getVisibility() == View.GONE ){
                    logic_sub.setVisibility(View.VISIBLE);
                }
                else {
                    logic_sub.setVisibility(View.GONE);
                }
        }});

    }

    public void onClickNOR(View view) {
    }

    public void onClickNAND(View view) {
    }

    public void onClickNOT(View view) {
    }

    public void onClickAND(View view) {
    }

    public void onClickOR(View view) {
    }

    public void onClickXOR(View view) {
    }
}
