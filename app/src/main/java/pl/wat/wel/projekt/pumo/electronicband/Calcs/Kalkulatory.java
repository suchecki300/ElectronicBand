package pl.wat.wel.projekt.pumo.electronicband.Calcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import pl.wat.wel.projekt.pumo.electronicband.R;
import pl.wat.wel.projekt.pumo.electronicband.ResistorCalcs;

public class Kalkulatory extends AppCompatActivity implements Animation.AnimationListener {
    TextView prosty;
    TextView logiczne;
    TextView resistors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulatory);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        prosty = (TextView) findViewById(R.id.prosty_k);
        logiczne = (TextView) findViewById(R.id.bramki_k);
        resistors = (TextView) findViewById(R.id.opisy_k);


        final Animation animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        final Animation animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        final Animation animZoomInFromZero = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in_from_zero);
        animZoomOut.setAnimationListener(this);
        animZoomIn.setAnimationListener(this);


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
                    logic_sub.startAnimation(animZoomInFromZero);
                    findViewById(R.id.calc_pic).startAnimation(animZoomOut);
                    findViewById(R.id.calc_pic_res).startAnimation(animZoomOut);
                }
                else {
                    logic_sub.setVisibility(View.GONE);
                    findViewById(R.id.calc_pic).startAnimation(animZoomIn);
                    findViewById(R.id.calc_pic_res).startAnimation(animZoomIn);
                }
        }});

        resistors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResistorCalcs.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
