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
        Intent intent = new Intent(getApplicationContext(), LogicCalcsNOR.class);
        startActivity(intent);
    }

    public void onClickNAND(View view) {
        Intent intent = new Intent(getApplicationContext(), LogicCalcsNAND.class);
        startActivity(intent);
    }

    public void onClickNOT(View view) {
        Intent intent = new Intent(getApplicationContext(), LogicCalcsNOT.class);
        startActivity(intent);
    }

    public void onClickAND(View view) {
        Intent intent = new Intent(getApplicationContext(), LogicCalcsAND.class );
        startActivity(intent);
    }

    public void onClickOR(View view) {
        Intent intent = new Intent(getApplicationContext(), LogicCalcsOR.class );
        startActivity(intent);
    }

    public void onClickXOR(View view) {
        Intent intent = new Intent(getApplicationContext(), LogicCalcsXOR.class);
        startActivity(intent);
    }
}
